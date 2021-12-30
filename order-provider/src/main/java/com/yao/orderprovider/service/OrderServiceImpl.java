package com.yao.orderprovider.service;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.yao.orderprovider.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yaojian on 2021/12/29 10:02
 *
 * @author
 */
@Slf4j
@DubboService(version = "1.0",group = "order-provider")
@Transactional(value = "financeCore")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addOrder(Order order) {
        System.out.println("order is :" + order);
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
}
