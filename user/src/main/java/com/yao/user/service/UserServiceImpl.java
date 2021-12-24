package com.yao.user.service;

import com.yao.common.entity.User;
import com.yao.common.service.Userservice;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Created by yaojian on 2021/12/23 15:27
 *
 * @author
 */
@DubboService(version = "1.1",group = "user-center")
public class UserServiceImpl implements Userservice {
    @Override
    public User getUserByName(String name) {
        User user = new User();
        user.setAge(10086);
        user.setName(name);
        user.setInstruction("我是用户中心provider");
        return user;
    }
}
