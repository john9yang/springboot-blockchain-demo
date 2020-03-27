package com.niudong.demo.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 联盟内用户钱包表,用于记录钱包内的币地址和余额
 * 
 * @author niudong
 */
@Entity
@Table(name = "tb_coin_deal")
public class UserWalletEntity {
  // 数据库ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // 用户ID
  private int userId;
  // 币地址
  private String coinAddress;
  // 币地址对应的余额
  private double coinBalance;
  // 交易创建时间
  private Date createTime;
  // 交易更新时间
  private Date updateTime;

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public double getCoinBalance() {
    return coinBalance;
  }

  public void setCoinBalance(double coinBalance) {
    this.coinBalance = coinBalance;
  }

  public String getCoinAddress() {
    return coinAddress;
  }

  public void setCoinAddress(String coinAddress) {
    this.coinAddress = coinAddress;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
