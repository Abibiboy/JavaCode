package com.example.blogtest.mapper;

import com.example.blogtest.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface ArticleMapper {
    List<Article> selectById(@Param("newId")Integer id);

    List<Article> selectAll();

    // 新增一篇文章
    int add(Article article);

    // 将 id = ? 的文章的 content 改成 ?
    int updateContentById(@Param("id") int id, @Param("content") String content);

    // 在添加新元素的时候，获取新元素的自增 id
    int addAndGetId(@Param("article") Article article);

    int delete(@Param("id") Integer id);

    // 根据参数进行 升序 / 降序 查询, 参数 rule 只能是 desc 或者 asc
    List<Article> selectBySort(@Param("rule") String rule);

    // 查找标题中带有 某关键词 的文章
    List<Article> selectByLike(@Param("key") String key);

    // 联合两张表，查询用户 id 的所有文章
    List<Article> selectByUserId();


}
