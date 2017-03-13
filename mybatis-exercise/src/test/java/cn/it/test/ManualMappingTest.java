package cn.it.test;

import cn.manual.mapper.Mapper;
import cn.manual.pojo.Orders;
import cn.manual.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Eric on 3/14/17.
 */
public class ManualMappingTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void findOrdersAndUser() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        Mapper mapper = openSession.getMapper(Mapper.class);

        List<Orders> ordersList = mapper.findOrdersAndUser();
        for (Orders orders : ordersList) {
            System.out.println(orders + "  " + orders.getUser());
        }
    }

    @Test
    public void findUserAndOrders() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        Mapper mapper = openSession.getMapper(Mapper.class);

        List<User> userList = mapper.findUserAndOrders();
        for (User user : userList) {
            for (Orders order : user.getOrders()) {
                System.out.println(user + "  " + order);
            }
        }
    }

}
