package com.niudong.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot")
public class HelloController {
  @RequestMapping("/test")
  public String index(int index) {
      return "Greetings from Spring Boot!"+index;
  }
}
