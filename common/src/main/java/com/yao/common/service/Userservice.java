package com.yao.common.service;

import com.yao.common.entity.User;

/**
 * Created by yaojian on 2021/12/9 20:32
 *
 * @author
 */
public interface Userservice {

    User getUserByName(String name);

    void createUser(String name,Integer age);

    User getUserById(String userId);

    void updateUser(User user);
}
