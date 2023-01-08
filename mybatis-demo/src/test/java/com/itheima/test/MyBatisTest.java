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
    public void testSelectAll() throws IOException {
        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4
        List<Brand> brands = brandMapper.selsectAll();
        System.out.println(brands);

        //5
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4
        int id=4;

        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {

        int status=1;
        String companyName="华为";
        String brandName="华为";

        //处理
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        Brand brand=new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        Map map=new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
//        map.put("brandName",brandName);

        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
//        SqlSession sqlSession=sqlSessionFactory.openSession();
        SqlSession sqlSession=sqlSessionFactory.openSession(false);

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {

        int status=1;
        String companyName="华为";
        String brandName="华为";

        //处理
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        Brand brand=new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

//        Map map=new HashMap();
////        map.put("status",status);
//        map.put("companyName",companyName);
////        map.put("brandName",brandName);

        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
//        List<Brand> brands = brandMapper.selectByCondition(map);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        //5
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {

        int status=1;
        String companyName="波导手机";
        String brandName="波导";
        String description="是覅巨额捐款分角色克里夫";
        int ordered=100;

        //处理
//        companyName="%"+companyName+"%";
//        brandName="%"+brandName+"%";

        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

//        Map map=new HashMap();
////        map.put("status",status);
//        map.put("companyName",companyName);
////        map.put("brandName",brandName);

        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4
        brandMapper.add(brand);
        Integer id =brand.getId();
        System.out.println(id);

        sqlSession.commit();
        //5
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {

        int status=0;
        String companyName="波公司";
//        String brandName="波导";
        String description="是覅巨fb克里夫";
        int ordered=200;
        int id = 6;

        //处理
//        companyName="%"+companyName+"%";
//        brandName="%"+brandName+"%";

        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

//        Map map=new HashMap();
////        map.put("status",status);
//        map.put("companyName",companyName);
////        map.put("brandName",brandName);

        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4
        int count = brandMapper.update(brand);
        System.out.println(count);

        sqlSession.commit();
        //5
        sqlSession.close();
    }

    @Test
    public void testDeletById() throws IOException {

        int id = 6;


        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4
        brandMapper.deleteById(id);

        sqlSession.commit();
        //5
        sqlSession.close();
    }

    @Test
    public void testDeletByIds() throws IOException {

        int[] ids = {4,5};


        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.获取代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4
//        brandMapper.deleteById(id);
        brandMapper.deleteByIds(ids);

        sqlSession.commit();
        //5
        sqlSession.close();
    }
}
