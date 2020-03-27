package com.niudong.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.niudong.demo.dao.entity.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Long> {
  public User findByLoginNameLike(String name);

  public User readByLoginName(String name);

  public List<User> getByCreatedateLessThan(Date star);
  
  public User readByLoginNameAndName(String loginName ,String name);
  
  @Query("select u from User u where u.name=:name")
  public User findByName(@Param("name")String name);
}
