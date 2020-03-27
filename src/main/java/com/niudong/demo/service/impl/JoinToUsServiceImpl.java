package com.niudong.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niudong.demo.dao.IJoinToUsDAO;
import com.niudong.demo.dao.entity.JoinToUsEntity;
import com.niudong.demo.service.JoinToUsService;

/**
 * JoinToUsService实现类
 * 
 * @author 牛冬
 *
 */
@Service
public class JoinToUsServiceImpl implements JoinToUsService {
  @Autowired
  private IJoinToUsDAO dao;

  // 增加机构
  public void join(String orgName, String orgPhone, String orgRepresent) {
    // 先检查这些信息是否已经录入
    JoinToUsEntity entity =
        dao.getByOrgNameAndOrgPhoneAndOrgRepresent(orgName, orgPhone, orgRepresent);

    // 已经录入，则不再录入
    if (entity != null) {
      return;
    }

    // 尚未录入
    JoinToUsEntity joinToUsEntity = new JoinToUsEntity();
    joinToUsEntity.setOrgName(orgName);
    joinToUsEntity.setOrgPhone(orgPhone);
    joinToUsEntity.setOrgRepresent(orgRepresent);
    dao.save(joinToUsEntity);
  }
}
