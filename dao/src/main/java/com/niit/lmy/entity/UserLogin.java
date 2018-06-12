package com.niit.lmy.entity;

import java.util.Date;
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
 * @since 2018-06-12
 */
@TableName("t_user_login")
public class UserLogin extends Model<UserLogin> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String uuid;
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
     * 密钥
     */
    private String secet;
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


    public String getUuid() {
        return uuid;
    }

    public UserLogin setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getSecet() {
        return secet;
    }

    public UserLogin setSecet(String secet) {
        this.secet = secet;
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

    public static final String UUID = "uuid";

    public static final String USER_ACCOUNT = "user_account";

    public static final String USER_PASSWORD = "user_password";

    public static final String SECET = "secet";

    public static final String USER_STATUS = "user_status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
        ", uuid=" + uuid +
        ", userAccount=" + userAccount +
        ", userPassword=" + userPassword +
        ", secet=" + secet +
        ", userStatus=" + userStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
