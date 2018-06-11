package com.niit.lmy.mapper;

import com.niit.lmy.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author miao
 * @since 2018-06-05
 */
@Component
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT * FROM t_role_permission AS a,t_permission AS b WHERE a.permission_id = b.item_id AND a.role_id = #{roleId} ")
    @Results({
            @Result(column="item_id",property="itemId"),
            @Result(column="parent_id",property="parentId"),
            @Result(column="menu_name",property="menuName"),
            @Result(column="menu_url",property="menuUrl"),
            @Result(column="perms",property="perms"),
            @Result(column="res_type",property="resType"),
            @Result(column="icon",property="icon"),
            @Result(column="order_num",property="orderNum"),
            @Result(column="delete_flag",property="deleteFlag"),
            @Result(column="create_time",property="createTime"),
            @Result(column="update_time",property="updateTime"),
    })
    List<Permission> getPermission(Integer roleId);
}
