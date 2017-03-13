package cn.it.dao;

import cn.it.pojo.User;

import java.util.List;

/**
 * Created by Eric on 3/11/17.
 */
public interface UserDao {

    User findUserById(int id) throws Exception;

    List<User> findUserByUserName(String username) throws Exception;

}
