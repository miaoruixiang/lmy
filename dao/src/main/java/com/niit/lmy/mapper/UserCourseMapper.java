package com.niit.lmy.mapper;

import com.niit.lmy.entity.UserCourse;
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
 * @since 2018-06-09
 */
@Component
public interface UserCourseMapper extends BaseMapper<UserCourse> {
    @Select("SELECT * FROM t_user_course AS a,t_activity AS b,t_group AS c WHERE a.course_id = c.course_id AND b.activity_group = c.group_id AND b.activity_id = #{activityId} AND a.user_account = #{account} ")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_account", property="userAccount"),
            @Result(column="course_id", property="courseId"),
            @Result(column="user_experience", property="userExperience"),
            @Result(column="user_nickname", property="userNickname"),
            @Result(column="user_number", property="userNumber"),
            @Result(column="user_resource_experience", property="userResourceExperience"),
            @Result(column="user_activity_experience", property="userActivityExperience"),
            @Result(column="user_resource_check_number", property="userResourceCheckNumber"),
            @Result(column="user_activity_join_number", property="userActivityJoinNumber"),
    })
    UserCourse getUserCourse(@Param("activityId") Integer activityId,@Param("account") String account);

    @Select("SELECT * FROM t_user_course AS a,t_resource AS b,t_group AS c WHERE a.course_id = c.course_id AND b.resource_group = c.group_id AND b.resource_id = #{resourceId} AND a.user_account = #{account} ")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_account", property="userAccount"),
            @Result(column="course_id", property="courseId"),
            @Result(column="user_experience", property="userExperience"),
            @Result(column="user_nickname", property="userNickname"),
            @Result(column="user_number", property="userNumber"),
            @Result(column="user_resource_experience", property="userResourceExperience"),
            @Result(column="user_activity_experience", property="userActivityExperience"),
            @Result(column="user_resource_check_number", property="userResourceCheckNumber"),
            @Result(column="user_activity_join_number", property="userActivityJoinNumber"),
    })
    UserCourse get(@Param("resourceId") Integer resourceId,@Param("account") String account);

    @Select("SELECT * FROM t_user_course AS a,t_resource AS b,t_group AS c WHERE a.course_id = c.course_id AND b.resource_group = c.group_id AND b.resource_id = #{resourceId} ")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_account", property="userAccount"),
            @Result(column="course_id", property="courseId"),
            @Result(column="user_experience", property="userExperience"),
            @Result(column="user_nickname", property="userNickname"),
            @Result(column="user_number", property="userNumber"),
            @Result(column="user_resource_experience", property="userResourceExperience"),
            @Result(column="user_activity_experience", property="userActivityExperience"),
            @Result(column="user_resource_check_number", property="userResourceCheckNumber"),
            @Result(column="user_activity_join_number", property="userActivityJoinNumber"),
    })
    List<UserCourse> getUserCourses(@Param("resourceId") Integer resourceId);
}
