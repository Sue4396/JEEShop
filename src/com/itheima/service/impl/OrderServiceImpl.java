package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.OrderService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:订单业务处理
 * indetail:
 *
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public PageBean<Order> findByUid(User loginUser, int pageNumber, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {

        int totalRecord = orderDao.findTotalRecordByUid(loginUser);

        PageBean<Order> pageBean = new PageBean<Order>(pageNumber,pageSize,totalRecord);
        List<Order> data = orderDao.findAllByUid(loginUser,pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(data);
        return pageBean;
    }
















}
