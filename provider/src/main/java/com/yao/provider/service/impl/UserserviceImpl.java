package com.yao.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yao.common.entity.User;
import com.yao.common.service.Userservice;

/**
 * Created by yaojian on 2021/12/9 20:07
 *
 * @author
 */
@Service()
//服务提供方跟消费方需要引用同一个接口包（实现同一个接口）
public class UserserviceImpl implements Userservice {
    @Override
    public User getUserByName(String name) {
        User user = new User();
        user.setName(name);
        user.setAge(25);
        return user;
    }
}