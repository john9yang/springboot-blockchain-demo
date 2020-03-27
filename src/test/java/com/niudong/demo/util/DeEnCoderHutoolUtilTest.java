package com.niudong.demo.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

/**
 * 基于Hutool工具类的加密解密类的单元测试类
 * 
 * @author 牛冬
 *
 */
public class DeEnCoderHutoolUtilTest {

  @Test
  public void testDesEncrypt() {
    // case1:String originalContent=null, String key=null
    String originalContent = null, key = null;
    Assert.assertEquals(DeEnCoderHutoolUtil.desEncrypt(originalContent, key), null);

    // case2:String originalContent!=null, String key=null
    originalContent = "好未来2019届校园招聘开启啦!有爱有科技,有你有未来";
    Assert.assertEquals(DeEnCoderHutoolUtil.desEncrypt(originalContent, key), null);

    // case2:String originalContent=null, String key!=null
    originalContent = null;
    key = "好未来是一家中国领先的教育科技企业，以科技驱动、人才亲密、品质领先为的核心目标。";
    Assert.assertEquals(DeEnCoderHutoolUtil.desEncrypt(originalContent, key), null);

    // case4:String originalContent!=null, String key!=null
    originalContent = "好未来2019届校园招聘开启啦!有爱有科技,有你有未来";
    key = new String(SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded());
    Assert.assertNotNull(DeEnCoderHutoolUtil.desEncrypt(originalContent, key));
  }

  @Test
  public void testDesDecrypt() {
    // case1:String ciphertext =null, String key = null
    String ciphertext = null, key = null;
    Assert.assertEquals(DeEnCoderHutoolUtil.desDecrypt(ciphertext, key), null);

    // case2:String ciphertext ！=null, String key = null
    String originalContent = "好未来2019届校园招聘开启啦!有爱有科技,有你有未来";
    String keyTmp =
        new String(SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded());
    ciphertext = DeEnCoderHutoolUtil.desEncrypt(originalContent, keyTmp);
    Assert.assertEquals(DeEnCoderHutoolUtil.desDecrypt(ciphertext, key), null);

    // case3:String ciphertext =null, String key != null
    ciphertext = null;
    key = new String(SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded());
    Assert.assertEquals(DeEnCoderHutoolUtil.desDecrypt(ciphertext, key), null);

    // case4:String ciphertext !=null, String key != null
    ciphertext = DeEnCoderHutoolUtil.desEncrypt(originalContent, key);
    Assert.assertNotNull(DeEnCoderHutoolUtil.desDecrypt(ciphertext, key));
  }

}
