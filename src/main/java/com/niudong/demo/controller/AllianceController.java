package com.niudong.demo.controller;

import org.testng.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niudong.demo.dao.entity.AllianceEntity;
import com.niudong.demo.service.AllianceService;

@RestController
@RequestMapping("/api/v1/alliance")
public class AllianceController {
  protected static Logger logger = LoggerFactory.getLogger(AllianceController.class);

  @Autowired
  private AllianceService allianceService;
  
  @RequestMapping(value = "/selectByIp", method = RequestMethod.GET)
  public AllianceEntity selectByAllianceIp(String allianceIp) {
    //如果IP数据为空
    if(Strings.isNullOrEmpty(allianceIp)) {
      return null;
    }
    
    return allianceService.selectByAllianceIp(allianceIp);
  }
}
