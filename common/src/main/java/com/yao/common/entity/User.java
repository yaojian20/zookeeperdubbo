package com.yao.common.entity;

import com.yao.common.base.BaseEntity;
import com.yao.common.util.SnowflakeIdWorker;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yaojian on 2021/12/9 20:03
 *
 * @author
 */
//需要实现序列化接口，不然无法传递

@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable{

    @Id
    @Column(name = "user_id", length = 32, updatable = false, unique = true)
    private String userId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "age", length = 4)
    private int age;

    @Column(name = "instruction", length = 500)
    private String instruction;

    @Column(name = "total_money", precision = 18, scale = 2)
    private BigDecimal totalMoney;

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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public void setEntityId(SnowflakeIdWorker snowflakeIdWorker) {
        if (StringUtils.isEmpty(userId)) {
            userId = String.valueOf(snowflakeIdWorker.nextId());
        }
    }
}
