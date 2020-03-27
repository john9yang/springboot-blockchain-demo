package com.niudong.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niudong.demo.dao.entity.JoinToUsEntity;

@Repository
public interface IJoinToUsDAO extends JpaRepository<JoinToUsEntity, Long> {

  public JoinToUsEntity getByOrgNameAndOrgPhoneAndOrgRepresent(String orgName, String orgPhone,
      String orgRepresent);
}
