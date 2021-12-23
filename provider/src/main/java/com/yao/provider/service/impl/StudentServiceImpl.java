package com.yao.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yao.common.entity.Student;
import com.yao.common.service.StudentService;

/**
 * Created by yaojian on 2021/12/20 14:33
 *
 * @author
 */

@Service(version = "1.0")
public class StudentServiceImpl implements StudentService {
    @Override
    public Student getStudent(String name) {
        System.out.println("name is :" + name);
        Student student = new Student();
        student.setName(name);
        student.setAge(22);
        student.setClassName("dubbo version-1.0");
        return student;
    }
}
