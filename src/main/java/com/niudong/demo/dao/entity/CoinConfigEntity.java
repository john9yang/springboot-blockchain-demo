package com.niudong.demo.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 联盟内激励配置表
 * 
 * @author niudong
 */
@Entity
@Table(name = "tb_coin_config")
public class CoinConfigEntity {
  // 数据库ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 业务类型
  private String bizType;
  // 币的总量
  private int coinTotal;
  // 机构预留币的数量
  private int coinReserved;
  // 每笔交易最小的币支付金额
  private double coinPerDeal;
  // 生成一个区块的奖励币数量
  private double coinBlockCreate;
  // 激励规则配置信息创建时间
  private Date createTime;
  // 激励规则配置信息更新时间
  private Date updateTime;

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public double getCoinBlockCreate() {
    return coinBlockCreate;
  }

  public void setCoinBlockCreate(double coinBlockCreate) {
    this.coinBlockCreate = coinBlockCreate;
  }

  public double getCoinPerDeal() {
    return coinPerDeal;
  }

  public void setCoinPerDeal(double coinPerDeal) {
    this.coinPerDeal = coinPerDeal;
  }

  public int getCoinReserved() {
    return coinReserved;
  }

  public void setCoinReserved(int coinReserved) {
    this.coinReserved = coinReserved;
  }

  public int getCoinTotal() {
    return coinTotal;
  }

  public void setCoinTotal(int coinTotal) {
    this.coinTotal = coinTotal;
  }

  public String getBizType() {
    return bizType;
  }

  public void setBizType(String bizType) {
    this.bizType = bizType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
