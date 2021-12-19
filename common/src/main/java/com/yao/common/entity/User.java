package com.yao.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yaojian on 2021/12/9 20:03
 *
 * @author
 */
//需要实现序列化接口，不然无法传输
public class User implements Serializable {

    private String name;

    private int age;

    private String instruction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
