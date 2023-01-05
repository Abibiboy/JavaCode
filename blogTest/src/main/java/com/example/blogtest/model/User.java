package com.example.blogtest.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    int id;
    String userName;
    String password;
    Date createTime; // 使用 Date 类型即可
    Date updateTime;
}
