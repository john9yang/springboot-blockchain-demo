package com.niudong.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Ordering;
import com.niudong.demo.blockchain.CoinInfo;
import com.niudong.demo.blockchain.DealInfo;
import com.niudong.demo.service.CoinService;

import cn.hutool.crypto.digest.DigestUtil;

import com.niudong.demo.dao.ICoinDealDAO;
import com.niudong.demo.dao.IUserWalletDAO;
import com.niudong.demo.dao.entity.CoinDealEntity;
import com.niudong.demo.dao.entity.UserWalletEntity;

/**
 * 联盟链中币交易服务的实现类
 * 
 * @author 牛冬
 *
 */
@Service
public class CoinServiceImpl implements CoinService {
  protected static Logger logger = LoggerFactory.getLogger(CoinServiceImpl.class);

  @Autowired
  private IUserWalletDAO userWalletDAO;
  @Autowired
  private ICoinDealDAO coinDealDAO;

  // 节点新生成区块的奖励币数量
  private static final int CREATE_BLOCK_COST = 100;

  // 模拟区块处理交易过程,其中dealInfo是交易信息，allianceNodeID是联盟节点信息
  public void deal(DealInfo dealInfo, int allianceNodeID) {
    //allianceNodeID有效性校验
    if(allianceNodeID <= 0) {
      return;
    }

    // 空校验
    if (dealInfo == null) {
      return;
    }

    // dealInfo内容校验
    boolean isCheckedPass = checkDealInfo(dealInfo);
    // 校验结果不合法，则抛弃，不处理
    if (!isCheckedPass) {
      return;
    }

    // 以下是校验结果合法时的处理逻辑
    processDeal(dealInfo, allianceNodeID);
  }

  // 校验结果合法时的处理逻辑，此处略去将数据JSON话写入区块的部分
  public void processDeal(DealInfo dealInfo, int allianceNodeID) {
    // 处理交易双方的逻辑
    processAndSaveDeal(dealInfo);

    // 将区块生成的奖励入库
    createBlockToAlliance(allianceNodeID);
  }

  // 处理交易双方的逻辑
  public void processAndSaveDeal(DealInfo dealInfo) {
    // 获取交易发起人ID
    int fromUserId = dealInfo.getFromUserId();
    // 获取交易收款人ID
    int toUserId = dealInfo.getToUserId();
    // 打包成区块的费用
    double blockCost = dealInfo.getBlockCost();
    // 获取交易发起人用于转账的CoinInfo列表
    List<CoinInfo> fromCoinList = dealInfo.getFromCoinList();
    // 获取交易费用
    double dealCost = dealInfo.getDealCost();

    // 对List<CoinInfo>排序，按balance从小到大排序
    Ordering<CoinInfo> coinOrdering = new Ordering<CoinInfo>() {
      public int compare(CoinInfo left, CoinInfo right) {
        return Double.compare(left.getBalance(), right.getBalance());
      }
    };
    fromCoinList = coinOrdering.sortedCopy(fromCoinList);

    // 查找满足交易费用的1个或多个address及对应的余额balance
    int index = 0, length = fromCoinList.size();
    double count = 0;
    for (int i = 0; i < length; i++) {
      count += fromCoinList.get(i).getBalance();

      // 保存该条币信息到收款人 + 保存到交易流水记录
      saveIntoTable(fromCoinList.get(i).getAddress(), fromCoinList.get(i).getAddress(),
          fromCoinList.get(i).getBalance(), fromCoinList.get(i).getBalance(), toUserId, fromUserId);

      if (count > dealCost) {
        index = i;

        // 分拆该条信息数据为两个账户
        double toUserDiffBalance = dealCost - (count - fromCoinList.get(i).getBalance());
        // 生成一个新币地址
        String coinAddress =
            DigestUtil.sha256Hex("create block,time is " + System.currentTimeMillis());
        saveIntoTable(null, coinAddress, toUserDiffBalance, toUserDiffBalance, toUserId,
            fromUserId);

        // 交易发起方账户变化 + 保存到交易流水记录
        saveIntoTable(fromCoinList.get(i).getAddress(), fromCoinList.get(i).getAddress(),
            fromCoinList.get(i).getBalance(), fromCoinList.get(i).getBalance() - toUserDiffBalance,
            toUserId, fromUserId);
      }
    }

    // 处理交易打包成区块费用blockCost
    for (int i = index; i < length; i++) {
      if (fromCoinList.get(i).getBalance() <= blockCost) {
        // 直接转移币地址即可

        // 保存该条币信息到收款人 + 保存到交易流水记录
        saveIntoTable(fromCoinList.get(i).getAddress(), fromCoinList.get(i).getAddress(),
            fromCoinList.get(i).getBalance(), fromCoinList.get(i).getBalance(), toUserId,
            fromUserId);

        blockCost -= fromCoinList.get(i).getBalance();
        if (blockCost == 0.0) {
          return;
        }
      }

      if (fromCoinList.get(i).getBalance() > blockCost) {
        // 分拆成两个新账户

        // 生成一个新币地址
        String coinAddress =
            DigestUtil.sha256Hex("create block,time is " + System.currentTimeMillis());
        saveIntoTable(null, coinAddress, blockCost, blockCost, toUserId, fromUserId);

        // 交易发起方账户变化 + 保存到交易流水记录
        saveIntoTable(fromCoinList.get(i).getAddress(), fromCoinList.get(i).getAddress(),
            fromCoinList.get(i).getBalance(), fromCoinList.get(i).getBalance() - blockCost,
            toUserId, fromUserId);
        return;
      }
    }

  }

  // 保存信息到两个表
  public void saveIntoTable(String fromAddress, String toAddress, double coinBalance,
      double coinBalanceDealed, int toUserId, int fromUserId) {
    UserWalletEntity userWalletEntity = new UserWalletEntity();
    userWalletEntity.setCoinAddress(toAddress);
    userWalletEntity.setCoinBalance(coinBalance);
    userWalletEntity.setCreateTime(new Date());
    userWalletEntity.setUpdateTime(new Date());
    userWalletEntity.setUserId(toUserId);
    userWalletDAO.save(userWalletEntity);

    // 保存到交易流水记录
    CoinDealEntity coinDealEntity = new CoinDealEntity();
    coinDealEntity.setCoinBalance(coinBalance);
    coinDealEntity.setCoinBalanceDealed(coinBalanceDealed);
    coinDealEntity.setCreateTime(new Date());
    coinDealEntity.setFromAddress(fromAddress);
    coinDealEntity.setFromUserId(fromUserId);
    coinDealEntity.setToUserId(toUserId);
    coinDealEntity.setToAddress(toAddress);
    coinDealDAO.save(coinDealEntity);
  }

  // 给区块生成的节点增加费用收入记录
  public void insertBlockCostToAlliance() {
    UserWalletEntity userWalletEntity = new UserWalletEntity();

    // userWalletEntity.setCoinAddress(coinAddress);
    userWalletDAO.save(userWalletEntity);
  }

  // 将区块生成的奖励入库
  public void createBlockToAlliance(int allianceNodeID) {
    UserWalletEntity userWalletEntity = new UserWalletEntity();

    // 新生成一个币地址用于存储区块打包费用
    String coinAddress = DigestUtil.sha256Hex("create block,time is " + System.currentTimeMillis());
    userWalletEntity.setCoinAddress(coinAddress);

    // 设置新生成区块的奖励
    double coinBalance = CREATE_BLOCK_COST;
    userWalletEntity.setCoinBalance(coinBalance);

    // 设计奖励所属人
    int userId = allianceNodeID;
    userWalletEntity.setUserId(userId);

    userWalletEntity.setCreateTime(new Date());
    userWalletEntity.setUpdateTime(new Date());

    userWalletDAO.save(userWalletEntity);
  }

  // dealInfo内容校验
  public boolean checkDealInfo(DealInfo dealInfo) {
    boolean result = false;

    // 交易双方的ID不合法,则直接返回
    if (dealInfo.getFromUserId() <= 0 || dealInfo.getToUserId() <= 0) {
      return result;
    }

    // 如果生成区块的交易费用小于等于0，则不合法
    if (dealInfo.getBlockCost() <= 0) {
      return result;
    }

    List<CoinInfo> fromCoinList = dealInfo.getFromCoinList();
    // 如果交易发起方的交易列表为空，则不合法
    if (fromCoinList == null || fromCoinList.size() == 0) {
      return result;
    }

    // 获取fromCoinList中涉及的交易地址对应的余额总量
    double allBalances = getAllCoinBalances(fromCoinList);
    // 获取交易费用
    double dealCost = dealInfo.getDealCost();
    // 余额不足交易费用或等于交易费用时没有用于支付区块创建的费用时，则不合法
    if (allBalances <= dealCost) {
      return result;
    }

    // 余额不足支付交易费用和创建区块的费用时不合法
    if (allBalances < dealCost + dealInfo.getBlockCost()) {
      return result;
    }

    return true;
  }

  // 计算List<CoinInfo> fromCoinList中涉及的交易地址对应的余额总量
  public double getAllCoinBalances(List<CoinInfo> fromCoinList) {
    double allBalances = 0d;
    for (CoinInfo coinInfo : fromCoinList) {
      allBalances += coinInfo.getBalance();
    }
    return allBalances;
  }

}
