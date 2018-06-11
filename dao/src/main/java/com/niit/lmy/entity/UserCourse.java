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
@TableName("t_user_course")
public class UserCourse extends Model<UserCourse> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户帐号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 班课id
     */
    @TableField("course_id")
    private Integer courseId;
    /**
     * 用户在班课的经验
     */
    @TableField("user_experience")
    private Integer userExperience;
    /**
     * 用户在班课的昵称
     */
    @TableField("user_nickname")
    private String userNickname;
    /**
     * 用户在班课的学号
     */
    @TableField("user_number")
    private String userNumber;
    /**
     * 查看资源经验
     */
    @TableField("user_resource_experience")
    private Integer userResourceExperience;
    /**
     * 参与活动经验
     */
    @TableField("user_activity_experience")
    private Integer userActivityExperience;
    /**
     * 查看资源个数
     */
    @TableField("user_resource_check_number")
    private Integer userResourceCheckNumber;
    /**
     * 参与活动个数
     */
    @TableField("user_activity_join_number")
    private Integer userActivityJoinNumber;


    public Integer getId() {
        return id;
    }

    public UserCourse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public UserCourse setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public UserCourse setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public Integer getUserExperience() {
        return userExperience;
    }

    public UserCourse setUserExperience(Integer userExperience) {
        this.userExperience = userExperience;
        return this;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public UserCourse setUserNickname(String userNickname) {
        this.userNickname = userNickname;
        return this;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public UserCourse setUserNumber(String userNumber) {
        this.userNumber = userNumber;
        return this;
    }

    public Integer getUserResourceExperience() {
        return userResourceExperience;
    }

    public UserCourse setUserResourceExperience(Integer userResourceExperience) {
        this.userResourceExperience = userResourceExperience;
        return this;
    }

    public Integer getUserActivityExperience() {
        return userActivityExperience;
    }

    public UserCourse setUserActivityExperience(Integer userActivityExperience) {
        this.userActivityExperience = userActivityExperience;
        return this;
    }

    public Integer getUserResourceCheckNumber() {
        return userResourceCheckNumber;
    }

    public UserCourse setUserResourceCheckNumber(Integer userResourceCheckNumber) {
        this.userResourceCheckNumber = userResourceCheckNumber;
        return this;
    }

    public Integer getUserActivityJoinNumber() {
        return userActivityJoinNumber;
    }

    public UserCourse setUserActivityJoinNumber(Integer userActivityJoinNumber) {
        this.userActivityJoinNumber = userActivityJoinNumber;
        return this;
    }

    public static final String ID = "id";

    public static final String USER_ACCOUNT = "user_account";

    public static final String COURSE_ID = "course_id";

    public static final String USER_EXPERIENCE = "user_experience";

    public static final String USER_NICKNAME = "user_nickname";

    public static final String USER_NUMBER = "user_number";

    public static final String USER_RESOURCE_EXPERIENCE = "user_resource_experience";

    public static final String USER_ACTIVITY_EXPERIENCE = "user_activity_experience";

    public static final String USER_RESOURCE_CHECK_NUMBER = "user_resource_check_number";

    public static final String USER_ACTIVITY_JOIN_NUMBER = "user_activity_join_number";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
        ", id=" + id +
        ", userAccount=" + userAccount +
        ", courseId=" + courseId +
        ", userExperience=" + userExperience +
        ", userNickname=" + userNickname +
        ", userNumber=" + userNumber +
        ", userResourceExperience=" + userResourceExperience +
        ", userActivityExperience=" + userActivityExperience +
        ", userResourceCheckNumber=" + userResourceCheckNumber +
        ", userActivityJoinNumber=" + userActivityJoinNumber +
        "}";
    }
}
