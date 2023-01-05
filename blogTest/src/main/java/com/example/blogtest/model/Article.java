package com.example.blogtest.model;

import lombok.Data;

import java.util.Date;
import java.util.*;

@Data  // 这个注解就是给该类加上 toString, get, set 等方法
public class Article {
    private int id;
    private String title;
    private String content;
    private Date createtime;
    private Date updatetime;
    private int userid;
    private int visitcount;
    String username;
}
