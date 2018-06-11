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
@TableName("t_group")
public class Group extends Model<Group> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "group_id", type = IdType.AUTO)
    private Integer groupId;
    /**
     * 班课id
     */
    @TableField("course_id")
    private Integer courseId;
    /**
     * 分组名称
     */
    @TableField("group_name")
    private String groupName;
    /**
     * 资源个数
     */
    @TableField("resources_number")
    private Integer resourcesNumber;
    /**
     * 活动个数
     */
    @TableField("activity_number")
    private Integer activityNumber;


    public Integer getGroupId() {
        return groupId;
    }

    public Group setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Group setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public Group setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public Integer getResourcesNumber() {
        return resourcesNumber;
    }

    public Group setResourcesNumber(Integer resourcesNumber) {
        this.resourcesNumber = resourcesNumber;
        return this;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public Group setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
        return this;
    }

    public static final String GROUP_ID = "group_id";

    public static final String COURSE_ID = "course_id";

    public static final String GROUP_NAME = "group_name";

    public static final String RESOURCES_NUMBER = "resources_number";

    public static final String ACTIVITY_NUMBER = "activity_number";

    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return "Group{" +
        ", groupId=" + groupId +
        ", courseId=" + courseId +
        ", groupName=" + groupName +
        ", resourcesNumber=" + resourcesNumber +
        ", activityNumber=" + activityNumber +
        "}";
    }
}
