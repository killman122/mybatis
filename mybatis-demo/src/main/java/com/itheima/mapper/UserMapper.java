package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();//返回一个集合, 集合中放置所有查询到的User对象
//    User selectById(int id);//根据id查询

    //使用注解的方式实现selectById的查询
    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);//根据id查询

    /*
        MyBatis 参数封装:
            * 单个参数:
                * 基本数据类型和String类型 -- 直接使用
                * Map -- 直接使用, 但是键名需要和参数占位符的名称一致
                * Collection -- 直接使用, 但是键名需要和参数占位符的名称一致
                    封装成Map集合
                        map.put("arg0",collection集合);
                        map.put("collection",collection集合);
                * POJO实体类 -- 可以直接使用, 属性名和参数占位符的名称一致
                * List -- 直接使用, 但是键名需要和参数占位符的名称一致
                    封装成Map集合
                        map.put("arg0",collection集合);
                        map.put("collection",collection集合);
                        map.put("List",List集合);
                * Array -- 直接使用, 但是键名需要和参数占位符的名称一致
                    封装成Map集合
                        map.put("arg0",array数组);
                        map.put("array",array数组);
            * 多个参数: 默认在mybatis中封装为Map集合, 但是使用arg0, arg1...作为key存储数据在使用插件时会编译报错, 使用param1, param2...作为key存储数据不会出现插件编译时的错误
            可以使用@Param注解给参数起一个别名, 在SQL语句中引用别名获取参数值, 替换Map集合中默认的arg键名
                map.put("arg0",参数1)
                map.put("parma1",参数1)
                map.put("arg1",参数2)
                map.put("param2",参数2)
                -----------------(@Param("username") String username, @Param("password") String password;)
                map.put("username",参数1)
                map.put("password",参数2)
                map.put("param1",参数1)
                map.put("param2",参数2)
            在mybatis底层中提供ParamNameResolver类, 用于解析参数, 将参数封装到Map集合中, key为参数名称, value为参数值
     */

//    User select(@Param("username") String username, @Param("password") String password);//多个参数, 使用@Param注解
    User select(@Param("username") String username, String password);//多个参数, 使用@Param注解
}
