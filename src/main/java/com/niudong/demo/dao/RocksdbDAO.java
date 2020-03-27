package com.niudong.demo.dao;

import javax.annotation.Resource;

import org.rocksdb.RocksDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

/**
 * RocksdbDAO工具类
 * 
 * @author 牛冬
 *
 */
@Component
public class RocksdbDAO {
  // 日志记录
  private Logger logger = LoggerFactory.getLogger(RocksdbDAO.class);

  @Resource
  private RocksDB rocksDB;

  private static final String CHARSET = "utf-8";

  // 存入数据或更改
  public void put(String key, String value) {
    if (Strings.isNullOrEmpty(key) || Strings.isNullOrEmpty(value)) {
      return;
    }
    try {
      rocksDB.put(key.getBytes(CHARSET), value.getBytes(CHARSET));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 获取数据
  public String get(String key) {
    if (Strings.isNullOrEmpty(key)) {
      return null;
    }

    try {
      byte[] bytes = rocksDB.get(key.getBytes(CHARSET));
      if (bytes != null) {
        return new String(bytes);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  // 删除数据
  public void delete(String key) {
    if (Strings.isNullOrEmpty(key)) {
      return;
    }

    try {
      rocksDB.delete(rocksDB.get(key.getBytes(CHARSET)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
