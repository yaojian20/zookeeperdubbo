package com.yao.comsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.yao.common.entity.Student;
import com.yao.common.entity.Teacher;
import com.yao.common.service.StudentService;
import com.yao.common.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by yaojian on 2021/12/20 15:33
 *
 * @author
 */

@RestController
public class TeacherController {

    //async表示开启异步调用
    @Reference(async = true,parameters = { "protocol", "dubbo" })
    private TeacherService teacherService;

    //async表示开启异步调用
    @Reference(version = "1.0",parameters = { "protocol", "dubbo" })
    private StudentService studentService;

    @RequestMapping("/teacher")
    public Teacher getTeacher() throws ExecutionException, InterruptedException {
        //异步调用接口，下面的程序继续运行，提高了效率
        teacherService.getTeacher();
        Future<Teacher> future = RpcContext.getContext().getFuture();
        System.out.println("hahahahahaha");
        //获得结果，此处会阻塞，直到拿到结果
        Teacher teacher = future.get();
        return teacher;
    }

    @RequestMapping("/student")
    public Student getStudent(String name) throws ExecutionException, InterruptedException {
        //由于service是单例，所以不能通过注解同步异步混用，只能在代码中异步调用
        //获得结果，此处会阻塞，直到拿到结果
        Future<Student> future = RpcContext.getContext().asyncCall(new Callable<Student>() {
            @Override
            public Student call() throws Exception {
                Thread.sleep(5000);

                System.out.println("11111111111111111111111");
                return studentService.getStudent(name);
            }
        });
        System.out.println("222222222222222222222222");
        Student student = future.get();
        return student;
    }


}
