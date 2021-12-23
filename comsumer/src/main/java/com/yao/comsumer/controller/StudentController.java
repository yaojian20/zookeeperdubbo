package com.yao.comsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yao.common.entity.Student;
import com.yao.common.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaojian on 2021/12/20 14:36
 *
 * @author
 */
@RestController
public class StudentController {

    //可以通过version来控制使用接口具体实现的版本控制
    @Reference(version = "1.0",parameters = { "protocol", "dubbo" })
    private StudentService studentService;

    @Reference(version = "2.0",parameters = { "protocol", "dubbo" })
    private StudentService newStudentService;


    @RequestMapping("/version1/student")
    public Student getStudentVersion1(String name){
        return studentService.getStudent(name);
    }

    @RequestMapping("/version2/student")
    public Student getStudentVersion2(String name){
        return newStudentService.getStudent(name);
    }



}
