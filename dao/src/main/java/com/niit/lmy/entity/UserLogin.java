package com.niit.lmy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author miao
 * @since 2018-05-31
 */
@TableName("t_user_login")
public class UserLogin extends Model<UserLogin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 帐号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 状态 0启用 1禁用
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public UserLogin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public UserLogin setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserLogin setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public UserLogin setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserLogin setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserLogin setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public static final String ID = "id";

    public static final String USER_ACCOUNT = "user_account";

    public static final String USER_PASSWORD = "user_password";

    public static final String USER_STATUS = "user_status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
        ", id=" + id +
        ", userAccount=" + userAccount +
        ", userPassword=" + userPassword +
        ", userStatus=" + userStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
