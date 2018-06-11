package com.niit.lmy.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2018-06-09
 */
@TableName("t_user_resource_check")
public class UserResourceCheck extends Model<UserResourceCheck> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "check_id", type = IdType.AUTO)
    private Integer checkId;
    /**
     * 资源id
     */
    @TableField("resource_id")
    private Integer resourceId;
    /**
     * 用户帐号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 资源查看状态 0未查看 1已查看
     */
    @TableField("resource_check_status")
    private Integer resourceCheckStatus;


    public Integer getCheckId() {
        return checkId;
    }

    public UserResourceCheck setCheckId(Integer checkId) {
        this.checkId = checkId;
        return this;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public UserResourceCheck setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public UserResourceCheck setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Integer getResourceCheckStatus() {
        return resourceCheckStatus;
    }

    public UserResourceCheck setResourceCheckStatus(Integer resourceCheckStatus) {
        this.resourceCheckStatus = resourceCheckStatus;
        return this;
    }

    public static final String CHECK_ID = "check_id";

    public static final String RESOURCE_ID = "resource_id";

    public static final String USER_ACCOUNT = "user_account";

    public static final String RESOURCE_CHECK_STATUS = "resource_check_status";

    @Override
    protected Serializable pkVal() {
        return this.checkId;
    }

    @Override
    public String toString() {
        return "UserResourceCheck{" +
        ", checkId=" + checkId +
        ", resourceId=" + resourceId +
        ", userAccount=" + userAccount +
        ", resourceCheckStatus=" + resourceCheckStatus +
        "}";
    }
}
