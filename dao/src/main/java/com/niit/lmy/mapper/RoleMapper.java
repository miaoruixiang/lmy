package com.niit.lmy.mapper;

import com.niit.lmy.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
 * @since 2018-06-03
 */
@Component
public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT * FROM t_user_role AS a,t_role AS b WHERE a.role_id = b.role_id AND a.user_account = #{account} AND a.course_id = #{courseId}")
    @Results({
            @Result(column="role_id",property="roleId"),
            @Result(column="role_name",property="roleName")
    })
    List<Role> getRole(@Param("account") String account,@Param("courseId")Integer courseId);
}
