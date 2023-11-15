package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
    MyBatis快速入门代码
 */
public class MyBatisDemo {
    public static void main(String[] args) throws Exception {
        // 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql, 需要传入在UserMapper中设置的唯一标识id, 实现命名空间.id
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);

        //4. 释放资源
        sqlSession.close();
        inputStream.close();
    }
}
