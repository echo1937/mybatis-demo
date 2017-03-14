package cn.it.mapper;

import cn.it.pojo.Orders;
import cn.it.pojo.User;

import java.util.List;

/**
 * Created by Eric on 3/14/17.
 */
public interface Mapper {

    List<Orders> findOrdersAndUser();

    List<User> findUserAndOrders();

}
