package cn.it.test;

import cn.it.mapper.UserMapper;
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
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 依然需要通过@Before生成sqlSessionFactory, 但不再需要注入给DaoImpl, 因为DaoImpl有MyBatis自动生成.
     * 只需要在方法中生成线程安全的SqlSession, 然后获取我们需要的Mapper, 即可调用Dao接口中定义的方法
     */
    @Test
    public void findUserById() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper userMapper = openSession.getMapper(UserMapper.class);

        System.out.println(userMapper.findUserById(10));
    }

    @Test
    public void fineUserByUsername() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper userMapper = openSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserByUsername("王%");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper userMapper = openSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("阿拉蕾");
        userMapper.insertUser(user);

        System.out.println(user.getId());
        openSession.commit();
    }
}
