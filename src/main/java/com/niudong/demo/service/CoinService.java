package com.niudong.demo.service;

import com.niudong.demo.blockchain.DealInfo;

/**
 * 联盟链中币交易服务类
 * 
 * @author 牛冬
 *
 */
public interface CoinService {
  public void deal(DealInfo dealInfo, int allianceNodeID);
}
