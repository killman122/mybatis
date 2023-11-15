package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();//返回一个集合, 集合中放置所有查询到的User对象
}
