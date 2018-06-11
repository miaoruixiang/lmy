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
@TableName("t_activity_work_refer")
public class ActivityWorkRefer extends Model<ActivityWorkRefer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "work_refer_id", type = IdType.AUTO)
    private Integer workReferId;
    /**
     * 活动id
     */
    @TableField("activity_id")
    private Integer activityId;
    /**
     * 提交用户帐号
     */
    @TableField("refer_user_account")
    private String referUserAccount;
    /**
     * 作业内容
     */
    @TableField("work_refer_info")
    private String workReferInfo;
    /**
     * 提交时间
     */
    @TableField("work_refer_time")
    private Date workReferTime;


    public Integer getWorkReferId() {
        return workReferId;
    }

    public ActivityWorkRefer setWorkReferId(Integer workReferId) {
        this.workReferId = workReferId;
        return this;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public ActivityWorkRefer setActivityId(Integer activityId) {
        this.activityId = activityId;
        return this;
    }

    public String getReferUserAccount() {
        return referUserAccount;
    }

    public ActivityWorkRefer setReferUserAccount(String referUserAccount) {
        this.referUserAccount = referUserAccount;
        return this;
    }

    public String getWorkReferInfo() {
        return workReferInfo;
    }

    public ActivityWorkRefer setWorkReferInfo(String workReferInfo) {
        this.workReferInfo = workReferInfo;
        return this;
    }

    public Date getWorkReferTime() {
        return workReferTime;
    }

    public ActivityWorkRefer setWorkReferTime(Date workReferTime) {
        this.workReferTime = workReferTime;
        return this;
    }

    public static final String WORK_REFER_ID = "work_refer_id";

    public static final String ACTIVITY_ID = "activity_id";

    public static final String REFER_USER_ACCOUNT = "refer_user_account";

    public static final String WORK_REFER_INFO = "work_refer_info";

    public static final String WORK_REFER_TIME = "work_refer_time";

    @Override
    protected Serializable pkVal() {
        return this.workReferId;
    }

    @Override
    public String toString() {
        return "ActivityWorkRefer{" +
        ", workReferId=" + workReferId +
        ", activityId=" + activityId +
        ", referUserAccount=" + referUserAccount +
        ", workReferInfo=" + workReferInfo +
        ", workReferTime=" + workReferTime +
        "}";
    }
}
