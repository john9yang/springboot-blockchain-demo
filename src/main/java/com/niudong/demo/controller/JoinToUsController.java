package com.niudong.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.util.Strings;

import com.niudong.demo.service.JoinToUsService;


@RestController
@RequestMapping("/api/v1/member")
public class JoinToUsController {

  protected static Logger logger = LoggerFactory.getLogger(JoinToUsController.class);

  @Autowired
  private JoinToUsService joinToUsService;

  @RequestMapping("/join")
  // String orgName:机构，String orgPhone：联系人手机号码，String orgRepresent:机构联系人
  public String join(String orgName, String orgPhone, String orgRepresent) {
    if (Strings.isNullOrEmpty(orgName) || Strings.isNullOrEmpty(orgPhone)
        || Strings.isNullOrEmpty(orgRepresent)) {
      return "请将机构名称、机构联系人、联系人手机号码完整输入！";
    }

    if (!isMobileOrPhone(orgPhone)) {
      return "联系人手机号码格式不正确！";
    }

    joinToUsService.join(orgName, orgPhone, orgRepresent);
    return "success";
  }

  // 验证是否是有效的电话或手机
  private boolean isMobileOrPhone(String orgPhone) {
    boolean isMoblie = isMobile(orgPhone);
    if (isMoblie == true) {
      return true;
    }

    return isPhone(orgPhone);
  }

  // 验证是否为手机号码
  private boolean isMobile(String str) {
    Pattern pattern = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
    Matcher matcher = pattern.matcher(str);
    return matcher.matches();
  }

  // 验证是否是座机电话号码
  private boolean isPhone(String str) {
    // 验证带区号的
    Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");
    // 验证没有区号的
    Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");

    Matcher m = null;
    boolean b = false;

    if (str.length() > 9) {
      m = p1.matcher(str);
      b = m.matches();
    } else {
      m = p2.matcher(str);
      b = m.matches();
    }

    return b;
  }

  public static void main(String args[]) {
    String str = "12201306219";
    Pattern pattern = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
    Matcher matcher = pattern.matcher(str);
    System.out.println(matcher.matches());
  }
}
