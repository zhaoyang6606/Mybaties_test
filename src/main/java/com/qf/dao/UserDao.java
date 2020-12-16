package com.qf.dao;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserDao {

    /**
     * 查询所有用户
     * @return  返回用户列表
     */

    @Select("select * from user")
    List<User> findAllUser() ;
}
