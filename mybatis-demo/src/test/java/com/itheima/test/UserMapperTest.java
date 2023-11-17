package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {
    @Test
    public void testSelect() throws Exception {
        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

        //3.获取Mapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        String username = "zhangsan";
        String password = "123";

        User user = mapper.select(username, password);
        System.out.println(user);

        //关闭流和session释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testSelectById() throws Exception {
        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

        //3.获取Mapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        User user = mapper.selectById(1);
        System.out.println(user);

        //关闭流和session释放资源
        sqlSession.close();
        inputStream.close();

    }
}
