package com.niudong.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * MerkleTree单元测试类
 * 
 * @author 牛冬
 *
 */
public class MerkleTreeTest {

  @Test
  public void testMerkleTree() {
    // case1:List<String> contents = null;
    List<String> contents = null;
    Assert.assertEquals(new MerkleTree(contents).getList(), null);
    Assert.assertEquals(new MerkleTree(contents).getRoot(), null);

    // case2:List<String> contents = new ArrayList<>();
    contents = new ArrayList<>();
    Assert.assertEquals(new MerkleTree(contents).getList(), null);
    Assert.assertEquals(new MerkleTree(contents).getRoot(), null);

    // case3:List<String> contents 有内容
    contents = Arrays.asList("区块链", "人工智能", "好未来", "K12教育全球第一优质公司");
    Assert.assertEquals(new MerkleTree(contents).getRoot().getHash(),
        "f2f520c7a23d88ea02a6940f12280ffb8a161772292f1f95d91ec1a6f2fbd3c2");
    Assert.assertEquals(new MerkleTree(contents).getRoot().getName(),
        "节点节点节点：区块链和节点：人工智能的父节点和节点节点：好未来和节点：K12教育全球第一优质公司的父节点的父节点");
    
    new MerkleTree(contents).traverseTreeNodes();
  }
}
