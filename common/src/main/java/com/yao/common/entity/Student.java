package com.yao.common.entity;

import java.io.Serializable;

/**
 * Created by yaojian on 2021/12/20 14:28
 *
 * @author
 */
public class Student implements Serializable {

    private String name;

    private String className;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
