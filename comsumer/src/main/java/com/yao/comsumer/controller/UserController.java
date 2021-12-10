package com.yao.comsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yao.common.entity.User;
import com.yao.common.service.Userservice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by yaojian on 2021/12/9 20:38
 *
 * @author
 */
@RestController
public class UserController {

    @Reference()
    private Userservice userservice;

    @RequestMapping("/user")
    public User getUser(String name){
        return userservice.getUserByName(name);
    }



}
