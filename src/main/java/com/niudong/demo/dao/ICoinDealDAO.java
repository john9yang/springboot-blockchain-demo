package com.niudong.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niudong.demo.dao.entity.CoinDealEntity;

/**
 * 联盟内币的交易明细表对应的DAO层
 * 
 * @author 牛冬
 *
 */
@Repository
public interface ICoinDealDAO extends JpaRepository<CoinDealEntity, Long> {

}
