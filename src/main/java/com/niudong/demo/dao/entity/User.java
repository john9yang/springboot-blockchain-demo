package com.niudong.demo.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "boot_user")
public class User implements Serializable {
  private static final long serialVersionUID = -6550777752269466791L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String name;

  private String loginName;

  private String password;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createdate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreatedate() {
    return createdate;
  }

  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User() {
    super();
    // TODO Auto-generated constructor stub
  }

  public User(Long id, String name, String loginName, String password, Date createdate) {
    super();
    this.id = id;
    this.name = name;
    this.loginName = loginName;
    this.password = password;
    this.createdate = createdate;

  }
}
