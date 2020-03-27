package com.niudong.demo.dao;

import java.util.Arrays;
import java.util.List;
/**
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
*/
/**
 * Couchdb的Config类
 * 
 * @author 牛冬
 *
 */
/**
 * 
 
@Configuration
@EnableCouchbaseRepositories
public class CouchdbConfig extends AbstractCouchbaseConfiguration {

  //启动时建立配置的集群的连接。客户端将发现所有节点并保持群集映射最新。
  @Override
  protected List<String> getBootstrapHosts() {
    return Arrays.asList("host1", "host2");
  }

  // 配置主数据桶的名称
  @Override
  protected String getBucketName() {
    return "default";
  }

  // 配置主数据桶的密码
  @Override
  protected String getBucketPassword() {
    return "";
  }
}
*/
