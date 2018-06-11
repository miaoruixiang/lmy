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
 * @since 2018-06-04
 */
@TableName("t_activity")
public class Activity extends Model<Activity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "activity_id", type = IdType.AUTO)
    private Integer activityId;
    /**
     * 发起人帐号
     */
    @TableField("publish_user_account")
    private String publishUserAccount;
    /**
     * 活动类型 0头脑风暴 1作业
     */
    @TableField("activity_type")
    private Integer activityType;
    /**
     * 活动标题
     */
    @TableField("activity_title")
    private String activityTitle;
    /**
     * 活动分组
     */
    @TableField("activity_group")
    private Integer activityGroup;
    /**
     * 活动经验
     */
    @TableField("activity_experience")
    private Integer activityExperience;
    /**
     * 活动内容
     */
    @TableField("activity_info")
    private String activityInfo;
    /**
     * 活动状态 0未开始 1进行中 2已结束
     */
    @TableField("activity_status")
    private Integer activityStatus;
    /**
     * 开始时间
     */
    @TableField("activity_start_time")
    private Date activityStartTime;
    /**
     * 结束时间
     */
    @TableField("activity_end_time")
    private Date activityEndTime;


    public Integer getActivityId() {
        return activityId;
    }

    public Activity setActivityId(Integer activityId) {
        this.activityId = activityId;
        return this;
    }

    public String getPublishUserAccount() {
        return publishUserAccount;
    }

    public Activity setPublishUserAccount(String publishUserAccount) {
        this.publishUserAccount = publishUserAccount;
        return this;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public Activity setActivityType(Integer activityType) {
        this.activityType = activityType;
        return this;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public Activity setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
        return this;
    }

    public Integer getActivityGroup() {
        return activityGroup;
    }

    public Activity setActivityGroup(Integer activityGroup) {
        this.activityGroup = activityGroup;
        return this;
    }

    public Integer getActivityExperience() {
        return activityExperience;
    }

    public Activity setActivityExperience(Integer activityExperience) {
        this.activityExperience = activityExperience;
        return this;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public Activity setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
        return this;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public Activity setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
        return this;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public Activity setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
        return this;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public Activity setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
        return this;
    }

    public static final String ACTIVITY_ID = "activity_id";

    public static final String PUBLISH_USER_ACCOUNT = "publish_user_account";

    public static final String ACTIVITY_TYPE = "activity_type";

    public static final String ACTIVITY_TITLE = "activity_title";

    public static final String ACTIVITY_GROUP = "activity_group";

    public static final String ACTIVITY_EXPERIENCE = "activity_experience";

    public static final String ACTIVITY_INFO = "activity_info";

    public static final String ACTIVITY_STATUS = "activity_status";

    public static final String ACTIVITY_START_TIME = "activity_start_time";

    public static final String ACTIVITY_END_TIME = "activity_end_time";

    @Override
    protected Serializable pkVal() {
        return this.activityId;
    }

    @Override
    public String toString() {
        return "Activity{" +
        ", activityId=" + activityId +
        ", publishUserAccount=" + publishUserAccount +
        ", activityType=" + activityType +
        ", activityTitle=" + activityTitle +
        ", activityGroup=" + activityGroup +
        ", activityExperience=" + activityExperience +
        ", activityInfo=" + activityInfo +
        ", activityStatus=" + activityStatus +
        ", activityStartTime=" + activityStartTime +
        ", activityEndTime=" + activityEndTime +
        "}";
    }
}
