package com.niudong.demo.util;

import org.testng.annotations.Test;
import org.testng.Assert;


/**
 * DeEnCoderCipherUtil的单元测试类
 * 
 * @author 牛冬
 *
 */
public class DeEnCoderCipherUtilTest {
  private static String ciphertextGlobal;

  @Test
  public void testEncrypt() {
    // case1:originalContent = null;key = null;
    String originalContent = null;
    String key = null;
    Assert.assertEquals(DeEnCoderCipherUtil.encrypt(originalContent, key), null);

    // case2:originalContent != null;key = null;
    originalContent = "好未来2019届校园招聘开启啦!有爱有科技,有你有未来";
    key = null;
    Assert.assertEquals(DeEnCoderCipherUtil.encrypt(originalContent, key), null);

    // case3:originalContent = null;key != null;
    originalContent = null;
    key = "好未来是一家中国领先的教育科技企业，以科技驱动、人才亲密、品质领先为的核心目标。";
    Assert.assertEquals(DeEnCoderCipherUtil.encrypt(originalContent, key), null);

    // case3:originalContent = null;key != null;
    originalContent = "好未来2019届校园招聘开启啦!有爱有科技,有你有未来";
    key = "好未来是一家中国领先的教育科技企业，以科技驱动、人才亲密、品质领先为的核心目标。";
    ciphertextGlobal = DeEnCoderCipherUtil.encrypt(originalContent, key);
    Assert.assertEquals(ciphertextGlobal,
        "yN4UjMm8gkeKtffzuOXA1rpCPc74Yj3C7vyM4BbQfxgoCj4RFxfp4I7QPBeN59jNipzELFiJ5NJL\r\n"
            + "zw4upkiydK7U2umHU7NH");

  }

  @Test(dependsOnMethods = {"testEncrypt"})
  public void testDecrypt() {
    // case1:String ciphertext = null, String key =null
    String ciphertext = null, key = null;
    Assert.assertEquals(DeEnCoderCipherUtil.decrypt(ciphertext, key), null);

    // case2:String ciphertext != null, String key =null
    ciphertext = ciphertextGlobal;
    Assert.assertEquals(DeEnCoderCipherUtil.decrypt(ciphertext, key), null);


    // case3:String ciphertext = null, String key !=null
    ciphertext = null;
    key = "好未来是一家中国领先的教育科技企业，以科技驱动、人才亲密、品质领先为的核心目标。";
    Assert.assertEquals(DeEnCoderCipherUtil.decrypt(ciphertext, key), null);

    // case4:String ciphertext != null, String key !=null
    ciphertext = ciphertextGlobal;
    key = "好未来是一家中国领先的教育科技企业，以科技驱动、人才亲密、品质领先为的核心目标。";
    Assert.assertEquals(DeEnCoderCipherUtil.decrypt(ciphertext, key), "好未来2019届校园招聘开启啦!有爱有科技,有你有未来");
  }
}
