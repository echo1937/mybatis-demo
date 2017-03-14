package cn.it.test;

import cn.it.mapper.Mapper;
import cn.it.pojo.Orders;
import cn.it.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Eric on 3/14/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class ManualMappingTest {

    @Autowired
    private Mapper mapper;

    @Test
    public void findOrdersAndUser() throws Exception {
        List<Orders> ordersList = mapper.findOrdersAndUser();

        for (Orders orders : ordersList) {
            System.out.println(orders + "  " + orders.getUser());
        }
    }

    @Test
    public void findUserAndOrders() throws Exception {
        List<User> userList = mapper.findUserAndOrders();

        for (User user : userList) {
            for (Orders order : user.getOrders()) {
                System.out.println(user + "  " + order);
            }
        }
    }

}
