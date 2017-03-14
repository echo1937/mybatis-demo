package cn.it.test;

import cn.it.mapper.UserMapper;
import cn.it.pojo.QueryVo;
import cn.it.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 3/14/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class DynamicSQLTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUserByQueryVo() throws Exception {
        User user = new User();
        user.setUsername("王");
        user.setSex("2");

        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        List<User> userList = userMapper.findUserByVo(queryVo);
        for (User userInList : userList) {
            System.out.println(userInList);
        }
    }

    @Test
    public void findUserCount() throws Exception {
        int count = userMapper.findUserCount();

        System.out.println("查询的行数为: " + count);
    }

    @Test
    public void findUserByUsernameAndSex() throws Exception {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user1.setUsername("王");
        user2.setSex("2");
        user3.setUsername("王");
        user3.setSex("2");

        System.out.println("查询'username=王': " + userMapper.findUserByUsernameAndSex(user1));
        System.out.println("查询'sex=2': " + userMapper.findUserByUsernameAndSex(user2));
        System.out.println("查询 '王 + 性别' 组合: " + userMapper.findUserByUsernameAndSex(user3));
        System.out.println("查询'null': " + userMapper.findUserByUsernameAndSex(user4));
    }

    @Test
    public void findUserByIdSet() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(16);
        list.add(30);

        QueryVo queryVo = new QueryVo();
        queryVo.setIds(list);

        List<User> userList = userMapper.findUserByIds(queryVo);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
