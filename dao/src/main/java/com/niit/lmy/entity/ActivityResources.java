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
 * @since 2018-06-04
 */
@TableName("t_activity_resources")
public class ActivityResources extends Model<ActivityResources> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "activity_resource_id", type = IdType.AUTO)
    private Integer activityResourceId;
    /**
     * 活动id
     */
    @TableField("activity_id")
    private Integer activityId;
    /**
     * 活动资源url
     */
    @TableField("activity_resource_url")
    private String activityResourceUrl;


    public Integer getActivityResourceId() {
        return activityResourceId;
    }

    public ActivityResources setActivityResourceId(Integer activityResourceId) {
        this.activityResourceId = activityResourceId;
        return this;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public ActivityResources setActivityId(Integer activityId) {
        this.activityId = activityId;
        return this;
    }

    public String getActivityResourceUrl() {
        return activityResourceUrl;
    }

    public ActivityResources setActivityResourceUrl(String activityResourceUrl) {
        this.activityResourceUrl = activityResourceUrl;
        return this;
    }

    public static final String ACTIVITY_RESOURCE_ID = "activity_resource_id";

    public static final String ACTIVITY_ID = "activity_id";

    public static final String ACTIVITY_RESOURCE_URL = "activity_resource_url";

    @Override
    protected Serializable pkVal() {
        return this.activityResourceId;
    }

    @Override
    public String toString() {
        return "ActivityResources{" +
        ", activityResourceId=" + activityResourceId +
        ", activityId=" + activityId +
        ", activityResourceUrl=" + activityResourceUrl +
        "}";
    }
}
