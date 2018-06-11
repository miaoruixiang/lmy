package com.niit.lmy.mapper;

import com.niit.lmy.entity.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author miao
 * @since 2018-06-08
 */
@Component
public interface CourseMapper extends BaseMapper<Course> {
    @Select("SELECT * FROM t_user_course AS a,t_course AS b WHERE a.course_id = b.course_id AND a.user_account = #{account} ")
    @Results({
            @Result(column="course_id",property="courseId"),
            @Result(column="course_invite_id",property="courseInviteId"),
            @Result(column="course_school",property="courseSchool"),
            @Result(column="course_department",property="courseDepartment"),
            @Result(column="course_class",property="courseClass"),
            @Result(column="course_name",property="courseName"),
            @Result(column="course_type",property="courseType"),
            @Result(column="course_logo",property="courseLogo"),
            @Result(column="course_requirement",property="courseRequirement"),
            @Result(column="course_schedule",property="courseSchedule"),
            @Result(column="course_test",property="courseTest"),
            @Result(column="create_user_account",property="createUserAccount"),
            @Result(column="course_status",property="courseStatus")
    })
    List<Course> getCourses(@Param("account") String account);

    @Select("SELECT MAX(course_id) FROM t_course")
    Integer getCourseId();


}
