package com.example.blogtest.mapper;

import com.example.blogtest.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {
    @Autowired
    ArticleMapper mapper; // 注入依赖
    @Test
    void selectAll() {
        List<Article> list = mapper.selectAll();
        for (Article a : list) {
            System.out.println(a);
        }
    }


    @Test
    void selectById() {
        List<Article> list = mapper.selectById(1);
        for (Article a : list) {
            System.out.println(a);
        }
    }

    @Test
    void add() {
        Article article = new Article();
        article.setId(2);
        article.setTitle("科学养猪");
        article.setContent("发家致富");
        article.setUserid(1);
        mapper.add(article); // 调用接口中的 add 方法，将这个对象传入
        System.out.println("添加成功");
    }

    @Test
    void updateContentById() {
        mapper.updateContentById(1, "准备冻手");
        System.out.println("修改成功");
    }

    @Test
    void addAndGetId() {
        // 这个是新插入的对象
        Article article = new Article();
        article.setId(3);
        article.setTitle("获取自增主键");
        // 然后 xml 文件中 keyProperty = 'id'，表示会将新增行的主键 id 赋值给这个对象的 id 属性！
        article.setContent("通过 useGeneratedKey 和 keyProperty 标签来设置");
        article.setUserid(1);
        mapper.add(article); // 调用接口中的 add 方法，将这个对象传入
        // 由于新行的自增主键赋值给了这个对象的 id 属性，所以我们直接通过 article.getId() 方法就可以获取 自增主键
        System.out.println(article.getId());
    }

    @Test
    void delete() {
        mapper.delete(3);
    }

    @Test
    void selectBySort() {
        List<Article> list = mapper.selectBySort("desc");
        for (Article a : list) {
            System.out.println(a);
        }
    }

    @Test
    void selectByLike() {
        List<Article> list = mapper.selectByLike("手机");
        for (Article a : list) {
            System.out.println(a);
        }
    }

    @Test
    void selectByUserId() {
        List<Article> list = mapper.selectByUserId();
        for (Article a : list) {
            System.out.println(a);
        }
    }
}