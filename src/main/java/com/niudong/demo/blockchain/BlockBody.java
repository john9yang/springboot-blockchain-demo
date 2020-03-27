package com.niudong.demo.blockchain;

import java.util.List;

import org.aspectj.apache.bcel.generic.Instruction;

/**
 * 区块body，里面存放交易的数组
 * 
 * @author niudong.
 */
public class BlockBody {
  private List<ContentInfo> contentInfos;

  public List<ContentInfo> getContentInfos () {
    return contentInfos;
  }

  public void setContentInfos (List< ContentInfo > contentInfos) {
    this. contentInfos = contentInfos;
  }
}
