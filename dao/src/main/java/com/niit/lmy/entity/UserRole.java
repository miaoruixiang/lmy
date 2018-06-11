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
 * @since 2018-06-03
 */
@TableName("t_user_role")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户帐号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 班课id
     */
    @TableField("course_id")
    private Integer courseId;


    public Integer getId() {
        return id;
    }

    public UserRole setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public UserRole setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public UserRole setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public UserRole setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public static final String ID = "id";

    public static final String USER_ACCOUNT = "user_account";

    public static final String ROLE_ID = "role_id";

    public static final String COURSE_ID = "course_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        ", id=" + id +
        ", userAccount=" + userAccount +
        ", roleId=" + roleId +
        ", courseId=" + courseId +
        "}";
    }
}
