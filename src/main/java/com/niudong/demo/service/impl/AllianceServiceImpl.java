package com.niudong.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niudong.demo.dao.IAllianceDAO;
import com.niudong.demo.dao.entity.AllianceEntity;
import com.niudong.demo.service.AllianceService;

/**
 * 联盟Service实现类
 * 
 * @author 牛冬
 *
 */
public class AllianceServiceImpl implements AllianceService {
  protected static Logger logger = LoggerFactory.getLogger(AllianceServiceImpl.class);

  @Autowired
  private IAllianceDAO allianceDAO;

  public AllianceEntity selectByAllianceIp(String allianceIp) {
    return allianceDAO.selectByAllianceIp(allianceIp);
  }
}
