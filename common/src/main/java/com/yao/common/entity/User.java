package com.yao.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yaojian on 2021/12/9 20:03
 *
 * @author
 */
@Data
//需要实现序列化接口，不然无法传输
public class User implements Serializable {

    private String name;

    private int age;

    private String instruction;


}
