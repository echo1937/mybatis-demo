package cn.it.dao;

import cn.it.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Eric on 3/11/17.
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        // SqlSession 是线程不安全的, 所以必须用完销毁
        SqlSession openSession = sqlSessionFactory.openSession();
        return (User) openSession.selectOne("test.findUserById", id);
    }

    public List<User> findUserByUserName(String userName) throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        return openSession.selectList("test.findUserByUsername", userName);
    }
}