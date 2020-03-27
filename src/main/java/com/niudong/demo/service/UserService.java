package com.niudong.demo.service;

import com.niudong.demo.dao.entity.User;

public interface UserService {
  public User readByLoginName(String name);

  public User readByLoginNameAndName(String loginName, String name);

  public User readByLoginNameLike(String loginName);

  public User readByName(String name);

  public void insert();
  
  public void delete();
}
