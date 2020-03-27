package com.niudong.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niudong.demo.dao.entity.User;
import com.niudong.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  protected static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @RequestMapping("/demo/{name}")
  @ResponseBody
  public String demoShowName(@PathVariable String name) {
    logger.debug("访问getUserByName,Name={}", name);
    userService.readByLoginName(name);
    return "name is " + name;
  }

  @RequestMapping("/demo/user/{loginName}")
  @ResponseBody
  public User demoShowUser2Name(@PathVariable String loginName) {
    logger.debug("访问getUserByName,Name={}", loginName);
    return userService.readByLoginName(loginName);
  }
  
  @RequestMapping("/demo/user/{loginName}/{name}")
  @ResponseBody
  public User demoShowUser2Name(@PathVariable String loginName,@PathVariable String name) {
    logger.debug("访问getUserByName,Name={}", name);
    return userService.readByLoginNameAndName(loginName,name);
  }
  
  @RequestMapping("/demo/userlike/{loginName}")
  @ResponseBody
  public User readByLoginNameLike(@PathVariable String loginName) {
    logger.debug("访问getUserByName,Name={}", loginName);
    return userService.readByLoginNameLike(loginName);
  }
  
  @RequestMapping("/demo/readByName/{name}")
  @ResponseBody
  public User readByName(@PathVariable String name) {
    logger.debug("访问getUserByName,Name={}", name);
    return userService.readByName(name);
  }
  
  @RequestMapping("/demo/insert")
  @ResponseBody
  public String insert() {
    userService.insert();
    return "success";
  }
  
  @RequestMapping("/demo/delete")
  @ResponseBody
  public String delete() {
    userService.delete();
    return "success";
  }
}
