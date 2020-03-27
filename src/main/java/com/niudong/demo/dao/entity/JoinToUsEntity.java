package com.niudong.demo.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_tojoin")
public class JoinToUsEntity implements Serializable {

  private static final long serialVersionUID = -6550777752269466791L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 机构名称
  private String orgName;

  // 机构联系方式
  private String orgPhone;

  // 机构联系人
  private String orgRepresent;

  // 申请时间
  private Date createTime = new Date();

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getOrgRepresent() {
    return orgRepresent;
  }

  public void setOrgRepresent(String orgRepresent) {
    this.orgRepresent = orgRepresent;
  }

  public String getOrgPhone() {
    return orgPhone;
  }

  public void setOrgPhone(String orgPhone) {
    this.orgPhone = orgPhone;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
