package com.niudong.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.niudong.demo.vo.KeySuitVO;
import com.niudong.demo.service.KeySuitService;

/**
 * 公私秘钥套装生成Controller
 * 
 * @author 牛冬
 *
 */
@RestController
@RequestMapping("/api/v1/key")
public class KeySuitController {
  protected static Logger logger = LoggerFactory.getLogger(KeySuitController.class);

  @Autowired
  private KeySuitService keySuitService;

  @GetMapping("/create")
  public KeySuitVO create() {
    return keySuitService.getRandowKeySuit();
  }
}
