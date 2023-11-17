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

    /**
     * 测试单条件多种条件选择的条件查询
     * @throws Exception
     */
    @Test
    public void testSelectByConditionSingle() throws Exception {
        //接收选择商品的商品id参数
        int id = 1;

        String companyname = "华为";
        String brandname = "华为";

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
        companyname = "%" + companyname + "%";
        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //第二种方式需要将参数封装成对象
        Brand brand = new Brand();
//        brand.setStatus(id);
//        brand.setBrandName(brandname);
//        brand.setCompanyName(companyname);

        //4. 执行方法
        List<Brand> brandList = brandMapper.selectByConditionSingle(brand);
        System.out.println(brandList);

        //释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testAdd() throws Exception {
        //接收选择商品的商品id参数
        String companyname = "华西能源";
        String brandname = "电能强权";
        int ordered = 1;
        String description = "数字世界";
        int status = 1;

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //第二种方式需要将参数封装成对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandname);
        brand.setCompanyName(companyname);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //4. 执行方法
        brandMapper.add(brand);

        //由于在MyBatis中默认关闭了事务的提交, 所以需要手动提交事务, 由于使用sqlSession对象执行sql所以也需要使用sqlSession对象提交事务
        //如果在获取sqlSession对象的时候填写了boolean类型的变量确定是否开启自动提交,如果为true则表示自动提交, 反之手动提交
//        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();

    }
    @Test
    public void testAdd2() throws Exception {
        //接收选择商品的商品id参数
        String companyname = "华西能源";
        String brandname = "电能强权";
        int ordered = 1;
        String description = "数字世界";
        int status = 1;

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //第二种方式需要将参数封装成对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandname);
        brand.setCompanyName(companyname);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //4. 执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //由于在MyBatis中默认关闭了事务的提交, 所以需要手动提交事务, 由于使用sqlSession对象执行sql所以也需要使用sqlSession对象提交事务
        //如果在获取sqlSession对象的时候填写了boolean类型的变量确定是否开启自动提交,如果为true则表示自动提交, 反之手动提交
//        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testUpdate() throws Exception {
        //接收选择商品的商品id参数
        int id = 9;
        String companyname = "东东能源";
        String brandname = "王道强权";
        int ordered = 1;
        String description = "数字世界";
        int status = 1;

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //第二种方式需要将参数封装成对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandname);
        brand.setCompanyName(companyname);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //4. 执行方法
        int update = brandMapper.update(brand);
        System.out.println(update);

        //由于在MyBatis中默认关闭了事务的提交, 所以需要手动提交事务, 由于使用sqlSession对象执行sql所以也需要使用sqlSession对象提交事务
        //如果在获取sqlSession对象的时候填写了boolean类型的变量确定是否开启自动提交,如果为true则表示自动提交, 反之手动提交
//        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testUpdate2() throws Exception {
        //接收选择商品的商品id参数
        int id = 8;
//        String companyname = "东东能源";
//        String brandname = "王道强权";
//        int ordered = 1;
//        String description = "数字世界";
//        int status = 1;

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //第二种方式需要将参数封装成对象
        Brand brand = new Brand();
        brand.setId(id);
//        brand.setCompanyName(companyname);
        brand.setStatus(0);


        //4. 执行方法
        int update = brandMapper.update2(brand);
        System.out.println(update);

        //由于在MyBatis中默认关闭了事务的提交, 所以需要手动提交事务, 由于使用sqlSession对象执行sql所以也需要使用sqlSession对象提交事务
        //如果在获取sqlSession对象的时候填写了boolean类型的变量确定是否开启自动提交,如果为true则表示自动提交, 反之手动提交
//        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testDeleteById() throws Exception {
        //接收选择商品的商品id参数
        int id = 8;
//        String companyname = "东东能源";
//        String brandname = "王道强权";
//        int ordered = 1;
//        String description = "数字世界";

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        //第二种方式需要将参数封装成对象
//        Brand brand = new Brand();
//        brand.setId(id);
////        brand.setCompanyName(companyname);
//        brand.setStatus(0);


        //4. 执行方法
        int i = brandMapper.deleteById(id);
        System.out.println(i);
        //由于在MyBatis中默认关闭了事务的提交, 所以需要手动提交事务, 由于使用sqlSession对象执行sql所以也需要使用sqlSession对象提交事务
        //如果在获取sqlSession对象的时候填写了boolean类型的变量确定是否开启自动提交,如果为true则表示自动提交, 反之手动提交
//        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testDeleteByIds() throws Exception {
        //接收选择商品的商品id参数
        int [] ids = {6,7,9};
//        String companyname = "东东能源";
//        String brandname = "王道强权";
//        int ordered = 1;
//        String description = "数字世界";

        // 处理参数也可以将Java中的对应的参数添加% 实现模糊查询中的类似于贪婪匹配的方法, 就不需要在Mapper的sql中再写
//        companyname = "%" + companyname + "%";
//        brandname = "%" + brandname + "%";

        //1. 加载核心配置文件, 获取 SqlSessionFactory对象 , 用于创建 SqlSession对象, 直接从网页中复制构建工厂的代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象, 用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        //第二种方式需要将参数封装成对象
//        Brand brand = new Brand();
//        brand.setId(id);
////        brand.setCompanyName(companyname);
//        brand.setStatus(0);


        //4. 执行方法
        int i = brandMapper.deleteByIds(ids);
        System.out.println(i);
        //由于在MyBatis中默认关闭了事务的提交, 所以需要手动提交事务, 由于使用sqlSession对象执行sql所以也需要使用sqlSession对象提交事务
        //如果在获取sqlSession对象的时候填写了boolean类型的变量确定是否开启自动提交,如果为true则表示自动提交, 反之手动提交
//        sqlSession.commit();

        //释放资源
        sqlSession.close();
        inputStream.close();

    }
}

