package com.yao.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yao.common.entity.Student;
import com.yao.common.service.StudentService;

/**
 * Created by yaojian on 2021/12/20 14:35
 *
 * @author
 */
@Service(version = "2.0")
public class NewStudentServiceImpl implements StudentService {
    @Override
    public Student getStudent(String name) {
        Student student = new Student();
        student.setName(name);
        student.setAge(33);
        student.setClassName("dubbo version-2.0");
        return student;
    }
}
