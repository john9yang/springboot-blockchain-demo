package com.niudong.demo.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 联盟内币的交易明细表,用于记录交易历史
 * 
 * @author niudong
 */
@Entity
@Table(name = "tb_coin_deal")
public class CoinDealEntity {

  // 数据库ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // 交易发起方用户ID
  private int fromUserId;
  // 交易发起方地址
  private String fromAddress;
  // 交易前账户余额
  private double coinBalance;
  // 交易接收方ID
  private int toUserId;
  // 交易接收方地址
  private String toAddress;
  // 交易后账户余额
  private double coinBalanceDealed;
  // 交易创建时间
  private Date createTime;

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public double getCoinBalanceDealed() {
    return coinBalanceDealed;
  }

  public void setCoinBalanceDealed(double coinBalanceDealed) {
    this.coinBalanceDealed = coinBalanceDealed;
  }

  public String getToAddress() {
    return toAddress;
  }

  public void setToAddress(String toAddress) {
    this.toAddress = toAddress;
  }

  public int getToUserId() {
    return toUserId;
  }

  public void setToUserId(int toUserId) {
    this.toUserId = toUserId;
  }

  public double getCoinBalance() {
    return coinBalance;
  }

  public void setCoinBalance(double coinBalance) {
    this.coinBalance = coinBalance;
  }

  public String getFromAddress() {
    return fromAddress;
  }

  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }

  public int getFromUserId() {
    return fromUserId;
  }

  public void setFromUserId(int fromUserId) {
    this.fromUserId = fromUserId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
