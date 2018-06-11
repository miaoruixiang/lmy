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
@TableName("t_activity_work_refer_resources")
public class ActivityWorkReferResources extends Model<ActivityWorkReferResources> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "work_refer_resource_id", type = IdType.AUTO)
    private Integer workReferResourceId;
    /**
     * 提交id
     */
    @TableField("work_refer_id")
    private Integer workReferId;
    /**
     * 提交资源url
     */
    @TableField("work_refer_resource")
    private String workReferResource;


    public Integer getWorkReferResourceId() {
        return workReferResourceId;
    }

    public ActivityWorkReferResources setWorkReferResourceId(Integer workReferResourceId) {
        this.workReferResourceId = workReferResourceId;
        return this;
    }

    public Integer getWorkReferId() {
        return workReferId;
    }

    public ActivityWorkReferResources setWorkReferId(Integer workReferId) {
        this.workReferId = workReferId;
        return this;
    }

    public String getWorkReferResource() {
        return workReferResource;
    }

    public ActivityWorkReferResources setWorkReferResource(String workReferResource) {
        this.workReferResource = workReferResource;
        return this;
    }

    public static final String WORK_REFER_RESOURCE_ID = "work_refer_resource_id";

    public static final String WORK_REFER_ID = "work_refer_id";

    public static final String WORK_REFER_RESOURCE = "work_refer_resource";

    @Override
    protected Serializable pkVal() {
        return this.workReferResourceId;
    }

    @Override
    public String toString() {
        return "ActivityWorkReferResources{" +
        ", workReferResourceId=" + workReferResourceId +
        ", workReferId=" + workReferId +
        ", workReferResource=" + workReferResource +
        "}";
    }
}
