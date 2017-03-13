package cn.it.test;

import cn.it.mapper.UserMapper;
import cn.it.pojo.QueryVo;
import cn.it.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 3/13/17.
 */
public class DynamicSQLTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void findUserByQueryVo() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("王");
        user.setSex("2");

        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        List<User> userList = mapper.findUserByVo(queryVo);
        for (User userInList : userList) {
            System.out.println(userInList);
        }
    }

    @Test
    public void findUserCount() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        int count = mapper.findUserCount();

        System.out.println("查询的行数为: " + count);
    }

    @Test
    public void findUserByUsernameAndSex() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user1.setUsername("王");
        user2.setSex("2");
        user3.setUsername("王");
        user3.setSex("2");

        System.out.println("查询'username=王': " + mapper.findUserByUsernameAndSex(user1));
        System.out.println("查询'sex=2': " + mapper.findUserByUsernameAndSex(user2));
        System.out.println("查询 '王 + 性别' 组合: " + mapper.findUserByUsernameAndSex(user3));
        System.out.println("查询'null': " + mapper.findUserByUsernameAndSex(user4));
    }

    @Test
    public void findUserByIdSet() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(16);
        list.add(30);

        QueryVo queryVo = new QueryVo();
        queryVo.setIds(list);

        List<User> userList = mapper.findUserByIds(queryVo);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
