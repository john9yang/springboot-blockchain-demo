package com.niudong.demo.blockchain;

/**
 * 每个币的实体信息
 * 
 * @author 牛冬
 *
 */
public class CoinInfo {
  // 币地址
  private String address;
  // 币地址对应的余额
  private double balance;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
