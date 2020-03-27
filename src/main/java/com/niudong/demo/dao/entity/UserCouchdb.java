package com.niudong.demo.dao.entity;
/**
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class UserCouchdb {
  @Id 
  private String id;

  // 姓
  @Field
  private String lastname;
  
  
  // 性别:1为女，0为男
  @Field
  private int sex;
  
  //年龄
  @Field
  private int age;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
*/
