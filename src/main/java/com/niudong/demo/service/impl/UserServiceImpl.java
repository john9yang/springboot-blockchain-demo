package com.niudong.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niudong.demo.dao.IUserDAO;
import com.niudong.demo.dao.entity.User;
import com.niudong.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private IUserDAO userDao;

  @Override
  public User readByLoginName(String loginName) {
    return userDao.readByLoginName(loginName);
  }
  
  @Override
  public User readByLoginNameAndName(String loginName ,String name) {
    return userDao.readByLoginNameAndName(loginName,name);
  }
  
  @Override
  public User readByLoginNameLike(String loginName) {
    return userDao.findByLoginNameLike(loginName);
  }
  
  @Override
  public User readByName(String name) {
    return userDao.findByName(name);
  }
  
  @Override
  public void insert() {
    User user = new User();
    user.setLoginName("insert");
    user.setName("insert");
    user.setPassword("123");
    user.setCreatedate(new Date());
    userDao.save(user);
  }
  
  @Override
  public void delete() {
    //userDao.delete(5l);
  }
}
