package cn.it.mapper;

import cn.it.pojo.User;
import cn.it.pojo.*;

import java.util.List;

/**
 * A. 原生DAO实现  (需要写DAO接口和DAO实现类)
 * B. 动态代理方式 (只需要写接口)
 *      1、Mapper接口的全路径名称和Mapper.xml中的namespace相同
 *      2、Mapper接口中的方法名和Mapper.xml中定义的statement的id相同
 *      3、Mapper接口中的方法的输入参数类型和mapper.xml中定义的statement的parameterType的类型相同
 *      4、Mapper接口中方法的输出参数类型和mapper.xml中定义的statement的resultType的类型相同
 */
public interface UserMapper {

    List<User> findUserByVo(QueryVo queryVo);

    int findUserCount();

    List<User> findUserByUsernameAndSex(User user);

    List<User> findUserByIds(QueryVo queryVo);

}
