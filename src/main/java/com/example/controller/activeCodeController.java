package com.example.controller;


import com.example.service.activeCodeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController   //注册掉就不会加载成Bean了
@RequestMapping("/activeCode")
public class activeCodeController {
    @Autowired
    private activeCodeService activeCodeService;

    /*注册*/
    @PostMapping("/register")
    //输入int类型的邀请码，然后
    public Boolean register(@RequestParam int code,@RequestParam String name,@RequestParam String pwd,@RequestParam String pwd2){
        Boolean flag = activeCodeService.getCode(code);

        if(flag){ //如果code存在，并且两次输入密码一致，则向数据库存入数据。
            if(activeCodeService.isSame(pwd,pwd2)) {
                if(activeCodeService.insertUser(code,name,pwd))
                    return true;
            }
        }
        return flag;
    }
    /*登录*/
    @PostMapping("/login")
    public Boolean Login(@RequestParam String name,@RequestParam String pwd){
        Boolean flag = activeCodeService.isMatch(name, pwd);
        return flag;
    }
}

