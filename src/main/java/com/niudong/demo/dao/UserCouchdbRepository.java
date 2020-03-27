package com.niudong.demo.dao;
/**
import java.util.List;

import org.springframework.data.couchbase.core.query.Dimensional;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.geo.Box;
import org.springframework.data.repository.CrudRepository;

import com.niudong.demo.dao.entity.UserCouchdb;

public interface UserCouchdbRepository extends CrudRepository<UserCouchdb, String> {
  List<UserCouchdb> findByLastnameAndAgeBetween(String lastName, int minAge, int maxAge);

  @View(designDocument = "user", viewName = "byName")
  List<UserCouchdb> findByLastname(String lastName);

  @Dimensional(designDocument = "userGeo", spatialViewName = "byLocation")
  List<UserCouchdb> findByLocationWithin(Box cityBoundingBox);
}
*/