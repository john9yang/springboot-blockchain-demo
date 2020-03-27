package com.niudong.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niudong.demo.dao.entity.AllianceEntity;

/**
 * AllianceDAO
 * 
 * @author 牛冬
 *
 */
@Repository
public interface IAllianceDAO extends JpaRepository<AllianceEntity, Long> {
  public AllianceEntity selectByAllianceIp(String allianceIp);
}
