package com.example.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface activeCodeService {
    /*注册*/
    //查询激活码是否存在，参数是激活码具体值，如果存在返回true，不存在返回false
    Boolean getCode(int code);
    //查询name是否存在，如果存在返回true，如果不存在返回false
    Boolean getName(String name);
    //验证两次输入的密码是否相同，如果相同返回true，如果不相同返回false
    Boolean isSame(String pwd1,String pwd2);

    Boolean insertUser(int code,String name,String pwd);

    /*登录*/
    //查询name和password是否匹配，如果匹配返回true，如果不匹配返回false
    Boolean isMatch(String name,String pwd);
}
