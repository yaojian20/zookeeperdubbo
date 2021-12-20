package com.yao.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yao.common.entity.Teacher;
import com.yao.common.service.TeacherService;

/**
 * Created by yaojian on 2021/12/20 15:30
 *
 * @author
 */

@Service()
public class TeacherServiceImpl implements TeacherService {

    @Override
    public Teacher getTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("测试老师");
        teacher.setDesc("测试专用！");
        return teacher;
    }

}
