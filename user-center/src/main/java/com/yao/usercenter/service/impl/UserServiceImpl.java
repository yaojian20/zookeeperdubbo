package com.yao.usercenter.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.yao.common.entity.User;
import com.yao.common.service.Userservice;
import com.yao.usercenter.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.math.BigDecimal;

/**
 * Created by yaojian on 2021/12/29 10:16
 *
 * @author
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @DubboReference(version = "1.1",group = "user-center")
    private Userservice userservice;


    @DubboReference(version = "1.0",group = "order-provider")
    private OrderService orderService;

    @Override
    public void test() {
        User user = new User();
        user.setTotalMoney(new BigDecimal(10000));
        user.setName("测试");
        user.setAge(25);
        Order order = new Order();
        order.setGoodsName("苹果");
        order.setTotalMoney(new BigDecimal(20));
        userservice.createUser("测试",25);
        //orderService.addOrder(order);
    }

    @Override
    public void shop() {
        String userId  = "925789002986946560";
        BigDecimal totalMoney = new BigDecimal(100);
        String goodName = "苹果";
        User user = userservice.getUserById(userId);
        user.setTotalMoney(user.getTotalMoney().subtract(totalMoney));
        userservice.updateUser(user);
        Order order = new Order();
        order.setGoodsName(goodName);
        order.setTotalMoney(totalMoney);
        order.setUserId(userId);
        //int a = 1/0;
        orderService.addOrder(order);
    }
}
