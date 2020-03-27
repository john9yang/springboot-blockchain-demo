package com.niudong.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niudong.demo.dao.entity.CoinConfigEntity;

/**
 * 联盟内激励配置表对应的DAO层
 * 
 * @author 牛冬
 *
 */
public interface ICoinConfigDAO extends JpaRepository<CoinConfigEntity, Long> {

  public CoinConfigEntity selectByBizType(String bizType);

}
