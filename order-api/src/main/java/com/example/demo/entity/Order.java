package com.example.demo.entity;

import com.example.demo.base.BaseEntity;
import com.example.demo.util.SnowflakeIdWorker;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yaojian on 2021/12/28 19:44
 *
 * @author
 */
@Entity
@Table(name = "good_order")
public class Order extends BaseEntity implements Serializable {

    @Id
    @Column(name = "order_id", length = 32, updatable = false, unique = true)
    private String orderId;

    @Column(name = "user_id", length = 32)
    private String userId;

    @Column(name = "total_money", precision = 18, scale = 2)
    private BigDecimal totalMoney;

    @Column(name = "goods_name", length = 200)
    private String goodsName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public void setEntityId(SnowflakeIdWorker snowflakeIdWorker) {
        if (StringUtils.isEmpty(orderId)) {
            orderId = String.valueOf(snowflakeIdWorker.nextId());
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", totalMoney=" + totalMoney +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
