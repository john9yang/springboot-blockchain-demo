package com.niudong.demo.service.impl;

import com.niudong.demo.service.KeySuitService;
import com.niudong.demo.vo.KeySuitVO;

import cn.hutool.crypto.asymmetric.RSA;

/**
 * 公私秘钥套装生成Service实现类
 * 
 * @author 牛冬
 *
 */
public class KeySuitServiceImpl implements KeySuitService {

  // 返回公私秘钥对
  public KeySuitVO getRandowKeySuit() {
    RSA rsa = new RSA();
    // 获得私钥
    String privateKey = rsa.getPrivateKeyBase64();
    // 获得公钥
    String publicKey = rsa.getPublicKeyBase64();

    KeySuitVO vo = new KeySuitVO(privateKey, publicKey);
    return vo;
  }
}
