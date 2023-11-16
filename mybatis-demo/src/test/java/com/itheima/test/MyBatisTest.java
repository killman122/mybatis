package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws Exception {
        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testSelectById() throws Exception {
        //接收选择商品的商品id参数
        int id = 1;

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //释放资源
        sqlSession.close();
        inputStream.close();

    }
    /**
     * 多条件查询的测试
     */
    @Test
    public void testSelectByCondition() throws Exception {
        //接收选择商品的商品id参数
        int status = 1;
        String companyname = "华为";
        String brandname = "华为";

        // 也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //第一种方法实现多个参数调用的
//        List<Brand> brandList = brandMapper.selectByCondition(status, brandname, companyname);

        //第二种方式需要将参数封装成对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandname);
//        brand.setCompanyName(companyname);
//        List<Brand> brandList = brandMapper.selectByCondition(brand);

        //第三种方式使用Map双例集合的方式传入
        //封装参数到Map集合中
        Map map = new HashMap();
//        map.put("status",status);
//        map.put("brandName",brandname);
        map.put("companyName",companyname);
        List<Brand> brandList = brandMapper.selectByCondition(map);

        System.out.println(brandList);

        //释放资源
        sqlSession.close();
        inputStream.close();

    }
}
