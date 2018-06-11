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
@TableName("t_activity_brain_storming_refer")
public class ActivityBrainStormingRefer extends Model<ActivityBrainStormingRefer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "storming_refer_id", type = IdType.AUTO)
    private Integer stormingReferId;
    /**
     * 活动id
     */
    @TableField("activity_id")
    private Integer activityId;
    /**
     * 提交用户id
     */
    @TableField("refer_user_account")
    private String referUserAccount;
    /**
     * 提交内容
     */
    @TableField("storming_refer_info")
    private String stormingReferInfo;
    /**
     * 提交图片url
     */
    @TableField("storming_refer_img")
    private String stormingReferImg;
    /**
     * 提交时间
     */
    @TableField("storming_refer_time")
    private Date stormingReferTime;


    public Integer getStormingReferId() {
        return stormingReferId;
    }

    public ActivityBrainStormingRefer setStormingReferId(Integer stormingReferId) {
        this.stormingReferId = stormingReferId;
        return this;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public ActivityBrainStormingRefer setActivityId(Integer activityId) {
        this.activityId = activityId;
        return this;
    }

    public String getReferUserAccount() {
        return referUserAccount;
    }

    public ActivityBrainStormingRefer setReferUserAccount(String referUserAccount) {
        this.referUserAccount = referUserAccount;
        return this;
    }

    public String getStormingReferInfo() {
        return stormingReferInfo;
    }

    public ActivityBrainStormingRefer setStormingReferInfo(String stormingReferInfo) {
        this.stormingReferInfo = stormingReferInfo;
        return this;
    }

    public String getStormingReferImg() {
        return stormingReferImg;
    }

    public ActivityBrainStormingRefer setStormingReferImg(String stormingReferImg) {
        this.stormingReferImg = stormingReferImg;
        return this;
    }

    public Date getStormingReferTime() {
        return stormingReferTime;
    }

    public ActivityBrainStormingRefer setStormingReferTime(Date stormingReferTime) {
        this.stormingReferTime = stormingReferTime;
        return this;
    }

    public static final String STORMING_REFER_ID = "storming_refer_id";

    public static final String ACTIVITY_ID = "activity_id";

    public static final String REFER_USER_ACCOUNT = "refer_user_account";

    public static final String STORMING_REFER_INFO = "storming_refer_info";

    public static final String STORMING_REFER_IMG = "storming_refer_img";

    public static final String STORMING_REFER_TIME = "storming_refer_time";

    @Override
    protected Serializable pkVal() {
        return this.stormingReferId;
    }

    @Override
    public String toString() {
        return "ActivityBrainStormingRefer{" +
        ", stormingReferId=" + stormingReferId +
        ", activityId=" + activityId +
        ", referUserAccount=" + referUserAccount +
        ", stormingReferInfo=" + stormingReferInfo +
        ", stormingReferImg=" + stormingReferImg +
        ", stormingReferTime=" + stormingReferTime +
        "}";
    }
}
