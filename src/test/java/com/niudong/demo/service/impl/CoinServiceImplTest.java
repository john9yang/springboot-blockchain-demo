package com.niudong.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.niudong.demo.blockchain.CoinInfo;
import com.niudong.demo.blockchain.DealInfo;
import com.niudong.demo.dao.ICoinDealDAO;
import com.niudong.demo.dao.IUserWalletDAO;

/**
 * CoinServiceImpl的测试类
 * 
 * @author 牛冬
 *
 */
public class CoinServiceImplTest {

  @Mock
  private IUserWalletDAO userWalletDAO;
  @Mock
  private ICoinDealDAO coinDealDAO;
  @InjectMocks
  private CoinServiceImpl service;

  @BeforeTest
  public void before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllCoinBalances() {
    // 构造Mock数据
    List<CoinInfo> fromCoinList = new ArrayList<>();
    CoinInfo ci1 = new CoinInfo();
    ci1.setAddress("1");
    ci1.setBalance(1.1d);
    fromCoinList.add(ci1);
    CoinInfo ci2 = new CoinInfo();
    ci2.setAddress("2");
    ci2.setBalance(2.2d);
    fromCoinList.add(ci2);

    // 执行Mock测试并验证结果
    Assert.assertEquals(Math.abs(service.getAllCoinBalances(fromCoinList) - 3.3d) < 0.01, true);
  }

  @Test
  public void testCheckDealInfo() {
    // case 1： DealInfo dealInfo 字段不设置值
    DealInfo dealInfo = new DealInfo();
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 2:fromUserId = -1 & toUserId = 0（默认）
    dealInfo.setFromUserId(-1);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 3:fromUserId = -1 & toUserId = -1
    dealInfo.setToUserId(-1);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 4:fromUserId = 1 & toUserId = -1
    dealInfo.setFromUserId(1);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 5:fromUserId = 1 & toUserId = 1 & blockCost 默认= 0
    dealInfo.setToUserId(1);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 6:fromUserId = 1 & toUserId = 1 & blockCost > 0 & FromCoinList默认为空
    dealInfo.setBlockCost(1);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 7:fromUserId = 1 & toUserId = 1 & blockCost > 0 & FromCoinList不为空,但size=0
    List<CoinInfo> fromCoinList = new ArrayList<>();
    dealInfo.setFromCoinList(fromCoinList);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 8:fromUserId = 1 & toUserId = 1 & blockCost > 0 & FromCoinList不为空,size!=0
    CoinInfo ci = new CoinInfo();
    ci.setBalance(1);
    fromCoinList.add(ci);
    Assert.assertEquals(service.checkDealInfo(dealInfo), true);

    // case 9:fromUserId = 1 & toUserId = 1 & blockCost > 0 & FromCoinList不为空,size!=0 ,dealCost=2
    // 验证：余额不足交易费用或等于交易费用时没有用于支付区块创建的费用时，则不合法
    dealInfo.setDealCost(2);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);

    // case 10:fromUserId = 1 & toUserId = 1 & blockCost > 0 & FromCoinList不为空,size!=0 ,dealCost=0.2
    // 余额不足支付交易费用和创建区块的费用时不合法
    dealInfo.setDealCost(0.2);
    Assert.assertEquals(service.checkDealInfo(dealInfo), false);
  }

  @Test
  public void testCreateBlockToAlliance() {
    // 无返回结果直接运行
    int allianceNodeID = 124;
    service.createBlockToAlliance(allianceNodeID);
  }

  @Test
  public void testInsertBlockCostToAlliance() {
    // 无返回结果直接运行
    service.insertBlockCostToAlliance();
  }

  @Test
  public void testSaveIntoTable() {
    // 无返回结果直接运行
    String fromAddress = "123";
    String toAddress = "234";
    double coinBalance = 1.0;
    double coinBalanceDealed = 2.0;
    int toUserId = 123;
    int fromUserId = 234;
    service.saveIntoTable(fromAddress, toAddress, coinBalance, coinBalanceDealed, toUserId,
        fromUserId);
  }

  @Test
  public void testProcessDeal() {
    // 无返回结果直接运行,由于本方法简单且会调用processAndSaveDeal方法，因此本测试方法主要测试processAndSaveDeal
    DealInfo dealInfo = new DealInfo();
    int allianceNodeID = 123;

    List<CoinInfo> fromCoinList = new ArrayList<>();
    CoinInfo ci1 = new CoinInfo();
    ci1.setBalance(1);
    fromCoinList.add(ci1);
    CoinInfo ci2 = new CoinInfo();
    ci2.setBalance(2);
    fromCoinList.add(ci2);
    dealInfo.setFromCoinList(fromCoinList);

    dealInfo.setDealCost(1.2);

    // case1:count > dealCost
    service.processDeal(dealInfo, allianceNodeID);

    // case2:
    dealInfo.setBlockCost(3);
    service.processDeal(dealInfo, allianceNodeID);
  }

  @Test
  public void testDeal() {
    // case1 DealInfo dealInfo = null & allianceNodeID = -1
    DealInfo dealInfo = null;
    int allianceNodeID = -1;
    service.deal(dealInfo, allianceNodeID);

    allianceNodeID = 123;
    service.deal(dealInfo, allianceNodeID);

    // case2: dealInfo != null 无返回结果直接运行,由于本方法简单且会调用processDeal方法，因此本测试方法主要测试processDeal
    dealInfo = new DealInfo();

    List<CoinInfo> fromCoinList = new ArrayList<>();
    CoinInfo ci1 = new CoinInfo();
    ci1.setBalance(1);
    fromCoinList.add(ci1);
    CoinInfo ci2 = new CoinInfo();
    ci2.setBalance(2);
    fromCoinList.add(ci2);
    dealInfo.setFromCoinList(fromCoinList);

    dealInfo.setDealCost(1.2);


    service.deal(dealInfo, allianceNodeID);
  }
}
