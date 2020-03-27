package com.niudong.demo.blockchain;

import java.util.List;

/**
 * 每个交易的实体信息
 * 
 * @author 牛冬
 *
 */
public class DealInfo {
  // 交易发起人
  private int fromUserId;
  // 交易发起人用于转账的CoinInfo列表
  private List<CoinInfo> fromCoinList;
  // 交易收款人
  private int toUserId;
  // 交易费用
  private double dealCost;
  // 打包成区块的费用
  private double blockCost;

  public double getBlockCost() {
    return blockCost;
  }

  public void setBlockCost(double blockCost) {
    this.blockCost = blockCost;
  }

  public double getDealCost() {
    return dealCost;
  }

  public void setDealCost(double dealCost) {
    this.dealCost = dealCost;
  }

  public int getToUserId() {
    return toUserId;
  }

  public void setToUserId(int toUserId) {
    this.toUserId = toUserId;
  }

  public List<CoinInfo> getFromCoinList() {
    return fromCoinList;
  }

  public void setFromCoinList(List<CoinInfo> fromCoinList) {
    this.fromCoinList = fromCoinList;
  }

  public int getFromUserId() {
    return fromUserId;
  }

  public void setFromUserId(int fromUserId) {
    this.fromUserId = fromUserId;
  }
}
