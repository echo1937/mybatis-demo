package cn.it.test;

import cn.it.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Eric on 3/13/17.
 */
public class UserTest {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * 通过@Before完成sqlSessionFactory的创建
     */
    @Before
    public void setUp() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    
    @Test
    public void findUserById() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        User user = openSession.selectOne("test.findUserById", 10);

        System.out.println(user);
        openSession.close();
    }

    @Test
    public void findUserByUsername() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.findUserByUsername", "%王%");

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void insert() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("小明");
        user.setAddress("荷兰");
        user.setSex("1");

        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        System.out.println("插入完成, 插入纪录的主键ID为: " + user.getId());
        sqlSession.close();
    }

    @Test
    public void delete() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById", 29);
        sqlSession.commit();
    }

    @Test
    public void update() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 先查找纪录, 再修改纪录
        User user = sqlSession.selectOne("test.findUserById", 26);
        user.setAddress("荷兰");

        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
    }
}
