package com.yao.usercenter.controller;

import com.yao.common.entity.User;
import com.yao.common.service.Userservice;
import com.yao.usercenter.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User getUserByName(String name){
        User user = userservice.getUserByName(name);
        return user;
    }

    @RequestMapping("/createUser")
    public void create(@RequestParam("name") String name, @RequestParam("age")Integer age){
        userservice.createUser(name,age);
    }

    @RequestMapping("/test")
    public void test(){
        userService.test();
    }

    @RequestMapping("/shop")
    public void shop(){
        userService.shop();
    }

}
