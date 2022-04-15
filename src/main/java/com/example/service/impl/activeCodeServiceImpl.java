package com.example.service.impl;

import com.example.mapper.codeMapper;
import com.example.mapper.userMapper;
import com.example.service.activeCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //定义为业务层对应的Bean
public class activeCodeServiceImpl implements activeCodeService {

    @Autowired
    private userMapper userMapper; //告诉框架让他实例化一个userMapper

    @Autowired
    private codeMapper codeMapper;  //这里报错，把codeMapper和userMapper的注解@Service换成@Repository就解决了，再细研究这个错误

    /*注册*/
    //查询激活码是否存在，参数是激活码具体值，如果存在返回true，不存在返回false
    public Boolean getCode(int code){
        int flag = 0;
        flag = codeMapper.getCode(code);
        return flag != 0;
    }
    //查询name是否存在，如果存在返回true，如果不存在返回false
    public Boolean getName(String name){
        int flag = 0;
        flag = userMapper.getName(name);
        return flag!=0;
    }

    //验证两次输入的密码是否相同，如果相同返回true，如果不相同返回false
    public Boolean isSame(String pwd1,String pwd2){
        return pwd1.equals(pwd2);
    }

    //如果激活码存在，两次输入的pwd相同->往数据库插入
    public Boolean insertUser(int codeID,String name,String pwd){
        int flag = 0;
        flag = userMapper.insertUser(codeID,name,pwd);
        return flag!=0;
    }

    /*登录*/
    //查询name和password是否匹配，如果匹配返回true，如果不匹配返回false
    public Boolean isMatch(String name,String pwd){
        return name.equals(userMapper.getPwdByName(pwd));
    }

}
