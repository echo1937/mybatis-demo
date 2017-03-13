package cn.manual.mapper;

import cn.manual.pojo.Orders;
import cn.manual.pojo.User;

import java.util.List;

/**
 * Created by Eric on 3/14/17.
 */
public interface Mapper {

    List<Orders> findOrdersAndUser();

    List<User> findUserAndOrders();

}
