package com.example.demo.service;

import com.example.demo.entity.Order;

/**
 * Created by yaojian on 2021/12/29 9:43
 *
 * @author
 */
public interface OrderService{

    void addOrder(Order order);

    void update(Order order);

}
