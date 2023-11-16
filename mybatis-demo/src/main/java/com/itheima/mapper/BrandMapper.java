package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import javax.jws.Oneway;
import java.util.List;
import java.util.Map;

/**
 * 查询所有
 */
public interface BrandMapper {
    /**
     * 查询所有
     */
    public List<Brand> selectAll();

    /*
     * 查看详情:根据id查询
     */
    public Brand selectById(int id);

    /*
     * 条件查询: 根据状态status,模糊查询品牌名brand_name模糊查询公司名company_name
     * 参数的接收方式有三种, 第一种传入三个参数使用@Param("SQL语句中的参数占位符名称")注解注解只是为了能够将各个参数和传入的相应的值进行绑定但是不使用注解也是可以传入多个参数只是参数的对应关系不能确定,
     * 第二种传入一个Brand对象, 如果所有查询的字段都可以在一个Java实体类中找到对应的, 那么就传入这个类的对象, 前提是这个创建的对象中已经设置好相关的属性可以是使用set方法或者是一些有参构造器
     * 第三方式传入一个Map双例集合的key-value键值对
     *
     * 1. 散装查询: 如果方法中有多个参数, 需要使用@Param("SQL参数占位符名称")注解
     * 2. 对象参数: 对象的属性名称要和参数占位符名称一致
     * 3. Map集合参数
     */
    //第一种方式传入多个参数
//    public List<Brand> selectByCondition(@Param("status") int status, @Param("brandName") String brandName, @Param("companyName") String companyName);
    //第二种方式传入一个数据库中的表对应Java实体对象
//    public List<Brand> selectByCondition(Brand brand);
    //第三种方式使用Map双例集合的方式传入
    public List<Brand> selectByCondition(Map map);
}
