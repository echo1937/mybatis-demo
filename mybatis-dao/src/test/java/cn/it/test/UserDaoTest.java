package cn.it.test;

import cn.it.dao.UserDaoImpl;
import cn.it.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Eric on 3/13/17.
 */
public class UserDaoTest {

    private SqlSessionFactory sqlSessionFactory;
    
    @Before
    public void setUp() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 每次使用DaoImpl时, 以构造函数传参的方式将sqlSessionFactory注入给DaoImpl, 然后调用DaoImpl的方法完成数据库操作
     */
    @Test
    public void testSelectById() throws Exception {
        System.out.println(new UserDaoImpl(sqlSessionFactory).findUserById(10));
    }

    @Test
    public void testSelectByUsername() throws Exception {
        List<User> userByUserName = new UserDaoImpl(sqlSessionFactory).findUserByUserName("王%");

        for (User user : userByUserName) {
            System.out.println(user);
        }
    }

}