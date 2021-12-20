package com.yao.common.entity;

import java.io.Serializable;

/**
 * Created by yaojian on 2021/12/20 15:28
 *
 * @author
 */
public class Teacher implements Serializable {

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
