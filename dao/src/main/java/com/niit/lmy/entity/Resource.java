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
 * @since 2018-06-05
 */
@TableName("t_resource")
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "resource_id", type = IdType.AUTO)
    private Integer resourceId;
    /**
     * 发布者帐号
     */
    @TableField("publish_user_account")
    private String publishUserAccount;
    /**
     * 分组id
     */
    @TableField("resource_group")
    private Integer resourceGroup;
    /**
     * 经验值
     */
    @TableField("resource_experience")
    private Integer resourceExperience;
    /**
     * 知识点
     */
    @TableField("resource_knowledge")
    private String resourceKnowledge;
    /**
     * 学习要求
     */
    @TableField("resource_ask")
    private String resourceAsk;
    /**
     * 发布状态 0上传并发布 1上传但不发布
     */
    @TableField("resource_status")
    private Integer resourceStatus;
    /**
     * 资源类型 0视频 1音频 2图片 3文档
     */
    @TableField("resource_type")
    private Integer resourceType;
    /**
     * 资源连接
     */
    @TableField("resource_url")
    private String resourceUrl;
    /**
     * 发布时间
     */
    @TableField("resource_publish_time")
    private Date resourcePublishTime;


    public Integer getResourceId() {
        return resourceId;
    }

    public Resource setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getPublishUserAccount() {
        return publishUserAccount;
    }

    public Resource setPublishUserAccount(String publishUserAccount) {
        this.publishUserAccount = publishUserAccount;
        return this;
    }

    public Integer getResourceGroup() {
        return resourceGroup;
    }

    public Resource setResourceGroup(Integer resourceGroup) {
        this.resourceGroup = resourceGroup;
        return this;
    }

    public Integer getResourceExperience() {
        return resourceExperience;
    }

    public Resource setResourceExperience(Integer resourceExperience) {
        this.resourceExperience = resourceExperience;
        return this;
    }

    public String getResourceKnowledge() {
        return resourceKnowledge;
    }

    public Resource setResourceKnowledge(String resourceKnowledge) {
        this.resourceKnowledge = resourceKnowledge;
        return this;
    }

    public String getResourceAsk() {
        return resourceAsk;
    }

    public Resource setResourceAsk(String resourceAsk) {
        this.resourceAsk = resourceAsk;
        return this;
    }

    public Integer getResourceStatus() {
        return resourceStatus;
    }

    public Resource setResourceStatus(Integer resourceStatus) {
        this.resourceStatus = resourceStatus;
        return this;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public Resource setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public Resource setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public Date getResourcePublishTime() {
        return resourcePublishTime;
    }

    public Resource setResourcePublishTime(Date resourcePublishTime) {
        this.resourcePublishTime = resourcePublishTime;
        return this;
    }

    public static final String RESOURCE_ID = "resource_id";

    public static final String PUBLISH_USER_ACCOUNT = "publish_user_account";

    public static final String RESOURCE_GROUP = "resource_group";

    public static final String RESOURCE_EXPERIENCE = "resource_experience";

    public static final String RESOURCE_KNOWLEDGE = "resource_knowledge";

    public static final String RESOURCE_ASK = "resource_ask";

    public static final String RESOURCE_STATUS = "resource_status";

    public static final String RESOURCE_TYPE = "resource_type";

    public static final String RESOURCE_URL = "resource_url";

    public static final String RESOURCE_PUBLISH_TIME = "resource_publish_time";

    @Override
    protected Serializable pkVal() {
        return this.resourceId;
    }

    @Override
    public String toString() {
        return "Resource{" +
        ", resourceId=" + resourceId +
        ", publishUserAccount=" + publishUserAccount +
        ", resourceGroup=" + resourceGroup +
        ", resourceExperience=" + resourceExperience +
        ", resourceKnowledge=" + resourceKnowledge +
        ", resourceAsk=" + resourceAsk +
        ", resourceStatus=" + resourceStatus +
        ", resourceType=" + resourceType +
        ", resourceUrl=" + resourceUrl +
        ", resourcePublishTime=" + resourcePublishTime +
        "}";
    }
}
