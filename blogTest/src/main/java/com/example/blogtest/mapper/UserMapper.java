package com.example.blogtest.mapper;

import com.example.blogtest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper { // 命名无要求
    // 根据 id 查询文章
    List<User> selectById(@Param("id") Integer id);

    int insert(@Param("user") User user);

    // 插入
    int insertIfCondition(@Param("id") Integer id, @Param("username") String userName,
                          @Param("password") String password, @Param("createtime")Date createTime);

    // 插入（但是在上述场景中每一项都可能为空）
    int insertTrim(@Param("id") Integer id, @Param("userName") String userName,
                   @Param("password") String password, @Param("createTime")Date createTime,
                   @Param("updateTime") Date updateTime);

    // 根据 id, userName 查询 user 表, 但 id 和 userName 都可能为空
    List<User> selectWhere(@Param("id") Integer id, @Param("username") String userName);

    // 修改指定 id 的用户的用户名和密码
    int updateSet(@Param("id") Integer id, @Param("username") String userName,
                  @Param("password") String password);

    // 将 user 表中 id 在 idList 中的记录都删除掉
    int deleteForeach(@Param("collection") List<Integer> idList);
}
