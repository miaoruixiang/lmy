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
@TableName("t_permission")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限项id
     */
    @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;
    /**
     * 父菜单id 0一级菜单
     */
    @TableField("parent_id")
    private Integer parentId;
    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;
    /**
     * 菜单url
     */
    @TableField("menu_url")
    private String menuUrl;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)(预留)
     */
    private String perms;
    /**
     * 菜单类别 0目录  1 菜单  2 按钮（资源）
     */
    @TableField("res_type")
    private Integer resType;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序号
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 删除状态 0未删除 1删除
     */
    @TableField("delete_flag")
    private Integer deleteFlag;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public Long getItemId() {
        return itemId;
    }

    public Permission setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Permission setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public Permission setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public Permission setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
        return this;
    }

    public String getPerms() {
        return perms;
    }

    public Permission setPerms(String perms) {
        this.perms = perms;
        return this;
    }

    public Integer getResType() {
        return resType;
    }

    public Permission setResType(Integer resType) {
        this.resType = resType;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Permission setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public Permission setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public Permission setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Permission setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Permission setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public static final String ITEM_ID = "item_id";

    public static final String PARENT_ID = "parent_id";

    public static final String MENU_NAME = "menu_name";

    public static final String MENU_URL = "menu_url";

    public static final String PERMS = "perms";

    public static final String RES_TYPE = "res_type";

    public static final String ICON = "icon";

    public static final String ORDER_NUM = "order_num";

    public static final String DELETE_FLAG = "delete_flag";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.itemId;
    }

    @Override
    public String toString() {
        return "Permission{" +
        ", itemId=" + itemId +
        ", parentId=" + parentId +
        ", menuName=" + menuName +
        ", menuUrl=" + menuUrl +
        ", perms=" + perms +
        ", resType=" + resType +
        ", icon=" + icon +
        ", orderNum=" + orderNum +
        ", deleteFlag=" + deleteFlag +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
