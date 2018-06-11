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
 * @since 2018-06-07
 */
@TableName("t_user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户帐号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 昵称
     */
    @TableField("user_nickname")
    private String userNickname;
    /**
     * 用户姓名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 头像url
     */
    @TableField("user_avatar")
    private String userAvatar;
    /**
     * 用户生日
     */
    @TableField("user_birth")
    private Date userBirth;
    /**
     * 性别 0男 1女 2保密
     */
    @TableField("user_sex")
    private Integer userSex;
    /**
     * 学校
     */
    @TableField("user_school")
    private String userSchool;
    /**
     * 院系
     */
    @TableField("user_department")
    private String userDepartment;
    /**
     * 身份
     */
    @TableField("user_job")
    private String userJob;
    /**
     * 学号/工号
     */
    @TableField("user_number")
    private String userNumber;
    /**
     * 关联手机
     */
    @TableField("user_mobile")
    private String userMobile;
    /**
     * 关联邮箱
     */
    @TableField("user_email")
    private String userEmail;
    /**
     * 经验值
     */
    @TableField("user_experience")
    private Integer userExperience;
    /**
     * 魅力值
     */
    @TableField("user_charm")
    private Integer userCharm;
    /**
     * 创建的班课
     */
    @TableField("user_create_course")
    private Integer userCreateCourse;
    /**
     * 累计学生
     */
    @TableField("user_student")
    private Integer userStudent;
    /**
     * 发布资源
     */
    @TableField("user_publish_resources")
    private Integer userPublishResources;
    /**
     * 开展活动
     */
    @TableField("user_create_activity")
    private Integer userCreateActivity;
    /**
     * 累计发起签到
     */
    @TableField("user_create_attendance")
    private Integer userCreateAttendance;
    /**
     * 加入的班课
     */
    @TableField("user_join_class")
    private Integer userJoinClass;
    /**
     * 累计参加签到
     */
    @TableField("user_join_attendance")
    private Integer userJoinAttendance;
    /**
     * 查看资源
     */
    @TableField("user_see_resources")
    private Integer userSeeResources;
    /**
     * 参加活动
     */
    @TableField("user_join_activity")
    private Integer userJoinActivity;
    /**
     * 学习视频
     */
    @TableField("user_video_study_number")
    private Integer userVideoStudyNumber;
    /**
     * 累计时长
     */
    @TableField("user_video_study_time")
    private Double userVideoStudyTime;
    /**
     * 讨论答疑
     */
    @TableField("user_discuss")
    private Integer userDiscuss;
    /**
     * 获得点赞
     */
    @TableField("user_laud")
    private Integer userLaud;
    /**
     * 创建时间
     */
    @TableField("user_create_time")
    private Date userCreateTime;
    /**
     * 更新时间
     */
    @TableField("user_update_time")
    private Date userUpdateTime;


    public Integer getId() {
        return id;
    }

    public UserInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public UserInfo setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public UserInfo setUserNickname(String userNickname) {
        this.userNickname = userNickname;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public UserInfo setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
        return this;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public UserInfo setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
        return this;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public UserInfo setUserSex(Integer userSex) {
        this.userSex = userSex;
        return this;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public UserInfo setUserSchool(String userSchool) {
        this.userSchool = userSchool;
        return this;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public UserInfo setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
        return this;
    }

    public String getUserJob() {
        return userJob;
    }

    public UserInfo setUserJob(String userJob) {
        this.userJob = userJob;
        return this;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public UserInfo setUserNumber(String userNumber) {
        this.userNumber = userNumber;
        return this;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public UserInfo setUserMobile(String userMobile) {
        this.userMobile = userMobile;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UserInfo setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public Integer getUserExperience() {
        return userExperience;
    }

    public UserInfo setUserExperience(Integer userExperience) {
        this.userExperience = userExperience;
        return this;
    }

    public Integer getUserCharm() {
        return userCharm;
    }

    public UserInfo setUserCharm(Integer userCharm) {
        this.userCharm = userCharm;
        return this;
    }

    public Integer getUserCreateCourse() {
        return userCreateCourse;
    }

    public UserInfo setUserCreateCourse(Integer userCreateCourse) {
        this.userCreateCourse = userCreateCourse;
        return this;
    }

    public Integer getUserStudent() {
        return userStudent;
    }

    public UserInfo setUserStudent(Integer userStudent) {
        this.userStudent = userStudent;
        return this;
    }

    public Integer getUserPublishResources() {
        return userPublishResources;
    }

    public UserInfo setUserPublishResources(Integer userPublishResources) {
        this.userPublishResources = userPublishResources;
        return this;
    }

    public Integer getUserCreateActivity() {
        return userCreateActivity;
    }

    public UserInfo setUserCreateActivity(Integer userCreateActivity) {
        this.userCreateActivity = userCreateActivity;
        return this;
    }

    public Integer getUserCreateAttendance() {
        return userCreateAttendance;
    }

    public UserInfo setUserCreateAttendance(Integer userCreateAttendance) {
        this.userCreateAttendance = userCreateAttendance;
        return this;
    }

    public Integer getUserJoinClass() {
        return userJoinClass;
    }

    public UserInfo setUserJoinClass(Integer userJoinClass) {
        this.userJoinClass = userJoinClass;
        return this;
    }

    public Integer getUserJoinAttendance() {
        return userJoinAttendance;
    }

    public UserInfo setUserJoinAttendance(Integer userJoinAttendance) {
        this.userJoinAttendance = userJoinAttendance;
        return this;
    }

    public Integer getUserSeeResources() {
        return userSeeResources;
    }

    public UserInfo setUserSeeResources(Integer userSeeResources) {
        this.userSeeResources = userSeeResources;
        return this;
    }

    public Integer getUserJoinActivity() {
        return userJoinActivity;
    }

    public UserInfo setUserJoinActivity(Integer userJoinActivity) {
        this.userJoinActivity = userJoinActivity;
        return this;
    }

    public Integer getUserVideoStudyNumber() {
        return userVideoStudyNumber;
    }

    public UserInfo setUserVideoStudyNumber(Integer userVideoStudyNumber) {
        this.userVideoStudyNumber = userVideoStudyNumber;
        return this;
    }

    public Double getUserVideoStudyTime() {
        return userVideoStudyTime;
    }

    public UserInfo setUserVideoStudyTime(Double userVideoStudyTime) {
        this.userVideoStudyTime = userVideoStudyTime;
        return this;
    }

    public Integer getUserDiscuss() {
        return userDiscuss;
    }

    public UserInfo setUserDiscuss(Integer userDiscuss) {
        this.userDiscuss = userDiscuss;
        return this;
    }

    public Integer getUserLaud() {
        return userLaud;
    }

    public UserInfo setUserLaud(Integer userLaud) {
        this.userLaud = userLaud;
        return this;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public UserInfo setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
        return this;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public UserInfo setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
        return this;
    }

    public static final String ID = "id";

    public static final String USER_ACCOUNT = "user_account";

    public static final String USER_NICKNAME = "user_nickname";

    public static final String USER_NAME = "user_name";

    public static final String USER_AVATAR = "user_avatar";

    public static final String USER_BIRTH = "user_birth";

    public static final String USER_SEX = "user_sex";

    public static final String USER_SCHOOL = "user_school";

    public static final String USER_DEPARTMENT = "user_department";

    public static final String USER_JOB = "user_job";

    public static final String USER_NUMBER = "user_number";

    public static final String USER_MOBILE = "user_mobile";

    public static final String USER_EMAIL = "user_email";

    public static final String USER_EXPERIENCE = "user_experience";

    public static final String USER_CHARM = "user_charm";

    public static final String USER_CREATE_COURSE = "user_create_course";

    public static final String USER_STUDENT = "user_student";

    public static final String USER_PUBLISH_RESOURCES = "user_publish_resources";

    public static final String USER_CREATE_ACTIVITY = "user_create_activity";

    public static final String USER_CREATE_ATTENDANCE = "user_create_attendance";

    public static final String USER_JOIN_CLASS = "user_join_class";

    public static final String USER_JOIN_ATTENDANCE = "user_join_attendance";

    public static final String USER_SEE_RESOURCES = "user_see_resources";

    public static final String USER_JOIN_ACTIVITY = "user_join_activity";

    public static final String USER_VIDEO_STUDY_NUMBER = "user_video_study_number";

    public static final String USER_VIDEO_STUDY_TIME = "user_video_study_time";

    public static final String USER_DISCUSS = "user_discuss";

    public static final String USER_LAUD = "user_laud";

    public static final String USER_CREATE_TIME = "user_create_time";

    public static final String USER_UPDATE_TIME = "user_update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
        ", id=" + id +
        ", userAccount=" + userAccount +
        ", userNickname=" + userNickname +
        ", userName=" + userName +
        ", userAvatar=" + userAvatar +
        ", userBirth=" + userBirth +
        ", userSex=" + userSex +
        ", userSchool=" + userSchool +
        ", userDepartment=" + userDepartment +
        ", userJob=" + userJob +
        ", userNumber=" + userNumber +
        ", userMobile=" + userMobile +
        ", userEmail=" + userEmail +
        ", userExperience=" + userExperience +
        ", userCharm=" + userCharm +
        ", userCreateCourse=" + userCreateCourse +
        ", userStudent=" + userStudent +
        ", userPublishResources=" + userPublishResources +
        ", userCreateActivity=" + userCreateActivity +
        ", userCreateAttendance=" + userCreateAttendance +
        ", userJoinClass=" + userJoinClass +
        ", userJoinAttendance=" + userJoinAttendance +
        ", userSeeResources=" + userSeeResources +
        ", userJoinActivity=" + userJoinActivity +
        ", userVideoStudyNumber=" + userVideoStudyNumber +
        ", userVideoStudyTime=" + userVideoStudyTime +
        ", userDiscuss=" + userDiscuss +
        ", userLaud=" + userLaud +
        ", userCreateTime=" + userCreateTime +
        ", userUpdateTime=" + userUpdateTime +
        "}";
    }
}
