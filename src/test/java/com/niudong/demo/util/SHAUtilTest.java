package com.niudong.demo.util;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SHAUtilTest {
  /**
   * SHAUtil测试类
   */

  // 测试getSHA256方法
  @Test
  public void testGetSHA256() {
    String originalStr = "区块链是分布式数据存储、点对点传输、共识机制、加密算法等计算机技术的新型应用模式。";
    Assert.assertEquals("3c8fede03b42a9a3186fb96d7f22a1862bcb00e445e0b29566c613590306e3da",
        SHAUtil.getSHA256BasedMD(originalStr));
  }

  // 测试getSHA256方法
  @Test
  public void testSha256BasedHutool() {
    String originalStr = "区块链是分布式数据存储、点对点传输、共识机制、加密算法等计算机技术的新型应用模式。";
    Assert.assertEquals("3c8fede03b42a9a3186fb96d7f22a1862bcb00e445e0b29566c613590306e3da",
        SHAUtil.sha256BasedHutool(originalStr));
  }
}
