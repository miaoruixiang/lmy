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
 * @since 2018-06-08
 */
@TableName("t_course")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 班课id
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;
    /**
     * 班课邀请码
     */
    @TableField("course_invite_id")
    private String courseInviteId;
    /**
     * 班课学校
     */
    @TableField("course_school")
    private String courseSchool;
    /**
     * 班课院系
     */
    @TableField("course_department")
    private String courseDepartment;
    /**
     * 班课班级
     */
    @TableField("course_class")
    private String courseClass;
    /**
     * 班课名称
     */
    @TableField("course_name")
    private String courseName;
    /**
     * 班课类型 0学校课表班课 1自定义
     */
    @TableField("course_type")
    private Integer courseType;
    /**
     * 班课图标
     */
    @TableField("course_logo")
    private String courseLogo;
    /**
     * 班课要求
     */
    @TableField("course_requirement")
    private String courseRequirement;
    /**
     * 班课进度
     */
    @TableField("course_schedule")
    private String courseSchedule;
    /**
     * 考试安排
     */
    @TableField("course_test")
    private String courseTest;
    /**
     * 创建人帐号
     */
    @TableField("create_user_account")
    private String createUserAccount;
    /**
     * 班课状态 0进行中 1已结束
     */
    @TableField("course_status")
    private Integer courseStatus;


    public Integer getCourseId() {
        return courseId;
    }

    public Course setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getCourseInviteId() {
        return courseInviteId;
    }

    public Course setCourseInviteId(String courseInviteId) {
        this.courseInviteId = courseInviteId;
        return this;
    }

    public String getCourseSchool() {
        return courseSchool;
    }

    public Course setCourseSchool(String courseSchool) {
        this.courseSchool = courseSchool;
        return this;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public Course setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
        return this;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public Course setCourseClass(String courseClass) {
        this.courseClass = courseClass;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public Course setCourseType(Integer courseType) {
        this.courseType = courseType;
        return this;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public Course setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
        return this;
    }

    public String getCourseRequirement() {
        return courseRequirement;
    }

    public Course setCourseRequirement(String courseRequirement) {
        this.courseRequirement = courseRequirement;
        return this;
    }

    public String getCourseSchedule() {
        return courseSchedule;
    }

    public Course setCourseSchedule(String courseSchedule) {
        this.courseSchedule = courseSchedule;
        return this;
    }

    public String getCourseTest() {
        return courseTest;
    }

    public Course setCourseTest(String courseTest) {
        this.courseTest = courseTest;
        return this;
    }

    public String getCreateUserAccount() {
        return createUserAccount;
    }

    public Course setCreateUserAccount(String createUserAccount) {
        this.createUserAccount = createUserAccount;
        return this;
    }

    public Integer getCourseStatus() {
        return courseStatus;
    }

    public Course setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
        return this;
    }

    public static final String COURSE_ID = "course_id";

    public static final String COURSE_INVITE_ID = "course_invite_id";

    public static final String COURSE_SCHOOL = "course_school";

    public static final String COURSE_DEPARTMENT = "course_department";

    public static final String COURSE_CLASS = "course_class";

    public static final String COURSE_NAME = "course_name";

    public static final String COURSE_TYPE = "course_type";

    public static final String COURSE_LOGO = "course_logo";

    public static final String COURSE_REQUIREMENT = "course_requirement";

    public static final String COURSE_SCHEDULE = "course_schedule";

    public static final String COURSE_TEST = "course_test";

    public static final String CREATE_USER_ACCOUNT = "create_user_account";

    public static final String COURSE_STATUS = "course_status";

    @Override
    protected Serializable pkVal() {
        return this.courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
        ", courseId=" + courseId +
        ", courseInviteId=" + courseInviteId +
        ", courseSchool=" + courseSchool +
        ", courseDepartment=" + courseDepartment +
        ", courseClass=" + courseClass +
        ", courseName=" + courseName +
        ", courseType=" + courseType +
        ", courseLogo=" + courseLogo +
        ", courseRequirement=" + courseRequirement +
        ", courseSchedule=" + courseSchedule +
        ", courseTest=" + courseTest +
        ", createUserAccount=" + createUserAccount +
        ", courseStatus=" + courseStatus +
        "}";
    }
}
