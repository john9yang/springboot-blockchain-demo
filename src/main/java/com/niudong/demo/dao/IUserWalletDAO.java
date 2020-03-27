package com.niudong.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niudong.demo.dao.entity.UserWalletEntity;

/**
 * 联盟内用户钱包表对应的DAO层
 * 
 * @author 牛冬
 *
 */
@Repository
public interface IUserWalletDAO extends JpaRepository<UserWalletEntity, Long> {

}
