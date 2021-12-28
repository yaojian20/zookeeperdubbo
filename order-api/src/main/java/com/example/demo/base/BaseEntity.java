package com.example.demo.base;

import com.example.demo.util.SnowflakeIdWorker;
import com.example.demo.util.SpringContextUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yaojian on 2021/12/24 16:12
 *
 * @author
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 创建人
     */
    @Column(name = "create_user", length = 32)
    @CreatedBy
    private String createUser;

    /**
     * 创建人的用户类型
     */
    @Column(name = "create_user_type", length = 20)
    private String createUserType;

    /**
     * 修改人
     */
    @Column(name = "update_user", length = 32)
    @LastModifiedBy
    private String updateUser;

    /**
     * 更新人的用户类型
     */
    @Column(name = "update_user_type",length = 20)
    @LastModifiedBy
    private String updateUserType;


    /**
     * 是否删除
     * 0-未删除 1-已删除
     */
    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete;

    @Transient
    public abstract void setEntityId(SnowflakeIdWorker snowflakeIdWorker);

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Boolean getIsDelete() {
        return isDelete == null ? false: isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUserType() {
        return createUserType;
    }

    public void setCreateUserType(String createUserType) {
        this.createUserType = createUserType;
    }

    public String getUpdateUserType() {
        return updateUserType;
    }

    public void setUpdateUserType(String updateUserType) {
        this.updateUserType = updateUserType;
    }

    @PrePersist
    public void prePersistent(){
        SnowflakeIdWorker snowflakeIdWorker = SpringContextUtils.getBean("snowflakeIdWorker");
        setEntityId(snowflakeIdWorker);

        if (isDelete == null) {
            setIsDelete(false);
        }
    }

    @PreUpdate
    public void preUpdate(){

        if (isDelete == null) {
            setIsDelete(false);
        }
    }

    /**
     * 用来传输当前登录用户
     */
    public static class CurrentUser{

        private String userId;
        private String userType;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }

    @Transient
    private CurrentUser currentUser;

    @Transient
    private String toUserId;

    @Transient
    private List<String> toUserIds;

    @Transient
    private String toSupplierId;

    @Transient
    private String transferRemark;

    /**
     * 设置当前登录用户
     * @param user
     */
    public void setCurrentUser(CurrentUser user){
        this.currentUser = user;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public CurrentUser getCurrentUser(){
        return this.currentUser;
    }

    /**
     * 获取转向人ID
     * @return
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * 设置转向人ID
     * @param toUserId
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 获取分单人
     * @return
     */
    public List<String> getToUserIds() {
        return toUserIds;
    }

    /**
     * 设置分单人
     * @param toUserIds
     */
    public void setToUserIds(List<String> toUserIds) {
        this.toUserIds = toUserIds;
    }

    public String getToSupplierId() {
        return toSupplierId;
    }

    public void setToSupplierId(String toSupplierId) {
        this.toSupplierId = toSupplierId;
    }

    public String getTransferRemark() {
        return transferRemark;
    }

    public void setTransferRemark(String transferRemark) {
        this.transferRemark = transferRemark;
    }


}
