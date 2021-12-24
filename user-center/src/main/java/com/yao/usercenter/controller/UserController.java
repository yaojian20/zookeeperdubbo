package com.yao.usercenter.controller;

import com.yao.common.entity.User;
import com.yao.common.service.Userservice;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaojian on 2021/12/23 19:56
 *
 * @author
 */
@RestController
public class UserController {

    @DubboReference(version = "1.1",group = "user-center")
    private Userservice userservice;

    @RequestMapping("/user")
    public User getUserByName(String name){
        User user = userservice.getUserByName(name);
        return user;
    }

}
