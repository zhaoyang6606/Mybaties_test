package com.qf.test;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:zhangyang
 * @Date: 2020-12-9 16:24
 * @Version 1.0
 */
public class MybatisTest {


    @Test
    public void testFindAll() throws IOException {

        //代码完全变了

        //1.读取SqlMapCofig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfg.xml");
        //1.1 ---- 创建SqlSessionFactoryBuilder---- 工厂类的构建者
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =
                new SqlSessionFactoryBuilder() ;
        //2.创建工厂类对象:SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //3.创建执行对象SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获取UserDao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //userDao----就是UserDao----子实现类
        //5.调用方法
        List<User> users =  userDao.findAllUser();
        if(users!=null){
            for(User user:users){
                System.out.println(user);
            }
        }else{
            System.out.println("list集合为空...");
        }

        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
