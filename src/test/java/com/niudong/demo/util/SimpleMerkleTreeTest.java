package com.niudong.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * SimpleMerkleTree的单元测试类
 * 
 * @author 牛冬
 *
 */
public class SimpleMerkleTreeTest {
  @Test
  public void testGetMerKleNodeList() {
    // case1:List<String> contentList = null;
    List<String> contentList = null;
    Assert.assertEquals(SimpleMerkleTree.getMerKleNodeList(contentList).size(), 0);

    // case2:List<String> contentList = new ArrayList<>();但无内容
    contentList = new ArrayList<>();
    Assert.assertEquals(SimpleMerkleTree.getMerKleNodeList(contentList).size(), 0);

    // case3:contentList有内容填充
    contentList = Arrays.asList("区块链", "人工智能", "好未来", "K12教育全球第一优质公司");
    Assert.assertEquals(SimpleMerkleTree.getMerKleNodeList(contentList).size(), 2);
  }

  @Test
  public void testGetTreeNodeHash() {
    // case1:List<String> contentList = null;
    List<String> contentList = null;
    Assert.assertEquals(SimpleMerkleTree.getTreeNodeHash(contentList), null);

    // case2:List<String> contentList = new ArrayList<>();但无内容
    contentList = new ArrayList<>();
    Assert.assertEquals(SimpleMerkleTree.getTreeNodeHash(contentList), null);

    // case3:contentList有内容填充
    contentList = Arrays.asList("区块链", "人工智能", "好未来", "K12教育全球第一优质公司");
    Assert.assertEquals(SimpleMerkleTree.getTreeNodeHash(contentList),
        "43225f744f39db7abadf7ce858efce387ace12984b5575628a47827061ef45a4");
  }
}
