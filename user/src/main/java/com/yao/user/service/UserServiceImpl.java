package com.yao.user.service;

import com.yao.common.entity.User;
import com.yao.common.service.Userservice;
import com.yao.user.repository.UserRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by yaojian on 2021/12/23 15:27
 *
 * @author
 */
@DubboService(version = "1.1",group = "user-center")
public class UserServiceImpl implements Userservice {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        User user = new User();
        user.setAge(10086);
        user.setName(name);
        user.setInstruction("我是用户中心provider");
        return user;
    }

    @Override
    public void createUser(String name, Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setInstruction("这个人很懒，什么都没有留下。。。。。。");
        user.setTotalMoney(new BigDecimal("100000"));
        userRepository.save(user);
    }
}
