package com.example.blogtest.mapper;

import com.example.blogtest.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper mapper;

    @Test
    void selectById() {
        List<User> list = mapper.selectById(1);
        for (User u : list) {
            System.out.println(u);
        }
    }

    @Test
    void insert() {
        User user = new User();
        user.setId(2);
        user.setUserName("小刘");
        user.setPassword("123456");
        mapper.insert(user);
    }

    @Test
    void insertIfCondition() {
        mapper.insertIfCondition(5, "测试", "test", null);
    }


    @Test
    void insertTrim() {
        mapper.insertTrim(7, "trim测试", "test", null, null);
    }

    @Test
    void selectWhere() {
        List<User> list = mapper.selectWhere(2, null);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void updateSet() {
        mapper.updateSet(2, "史强", null);
    }

    @Test
    void deleteForeach() {
        List<Integer> idList = new ArrayList<>();
        idList.add(4);
        idList.add(5);
        idList.add(6);
        mapper.deleteForeach(idList);
    }
}