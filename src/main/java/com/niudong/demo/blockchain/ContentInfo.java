package com.niudong.demo.blockchain;

/**
 * 区块body内一条内容实体
 * 
 * @author niudong.
 */
public class ContentInfo {
  /**
   * 新的json内容
   */
  private String jsonContent;
  /**
   * 时间戳
   */
  private Long timeStamp;
  /**
   * 公钥
   */
  private String publicKey;
  /**
   * 签名
   */
  private String sign;
  /**
   * 该操作的hash
   */
  private String hash;


  public String getJson() {
    return jsonContent;
  }

  public void setJsonContent(String jsonContent) {
    this.jsonContent = jsonContent;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }
}

