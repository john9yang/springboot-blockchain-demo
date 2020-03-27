package com.niudong.demo.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 联盟的成员表
 * 
 * @author niudong
 */
@Entity
@Table(name = "tb_alliance")
public class AllianceEntity {
  // 数据库ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // 联盟节点id
  private String allianceId;
  // 联盟节点名称
  private String allianceName;
  // 联盟节点IP白名单
  private String allianceIp;
  // 联盟节点信息创建时间
  private Date createTime;
  // 联盟节点信息更新时间
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAllianceId() {
    return allianceId;
  }

  public void setAllianceId(String allianceId) {
    this.allianceId = allianceId;
  }

  public String getAllianceName() {
    return allianceName;
  }

  public void setAllianceName(String allianceName) {
    this.allianceName = allianceName;
  }

  public String getAllianceIp() {
    return allianceIp;
  }

  public void setAllianceIp(String allianceIp) {
    this.allianceIp = allianceIp;
  }
}
