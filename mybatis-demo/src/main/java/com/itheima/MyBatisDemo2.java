package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.ARG_OUT;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//mapper代理开发
public class MyBatisDemo2 {

    public static void main(String[] args) throws IOException {
        //1.获取mybatis配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();

//        //3.执行sql
//        List<User> users =  sqlSession.selectList("test.selectAll");

        //3.1 获取UserMapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        User user=userMapper.selectById(2);

        System.out.println(users);
        System.out.println(user);

        //4.释放
        sqlSession.close();
    }
}
