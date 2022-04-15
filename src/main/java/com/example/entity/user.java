package com.example.entity;

import lombok.Data;
/*
* 用户实体类，数据库中的date是datetime类型
* */
@Data
public class user {
    private int codeID;
    String code;
    String date;

}
