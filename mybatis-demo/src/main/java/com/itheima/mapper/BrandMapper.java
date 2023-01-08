package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    //查询所有
    List<Brand> selsectAll();

    //查看详情
    Brand selectById(int id);

    //条件查询
    /*
    *  *参数接收
    *   1.散装参数：如果方法中有多个参数
    *   2.对象参数
    *   3.map集合参数
    *
     */

    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName")String brandName);

    List<Brand> selectByCondition(Map map);

//    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    //修改
    int update(Brand brand);

    //根据id删除
    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] id);
}
