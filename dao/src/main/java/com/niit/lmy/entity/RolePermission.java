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
 * @since 2018-06-05
 */
@TableName("t_role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_permission_id", type = IdType.AUTO)
    private Integer rolePermissionId;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 权限id
     */
    @TableField("permission_id")
    private Integer permissionId;


    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public RolePermission setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public RolePermission setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public RolePermission setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public static final String ROLE_PERMISSION_ID = "role_permission_id";

    public static final String ROLE_ID = "role_id";

    public static final String PERMISSION_ID = "permission_id";

    @Override
    protected Serializable pkVal() {
        return this.rolePermissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        ", rolePermissionId=" + rolePermissionId +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
