package com.niit.lmy.mapper;

import com.niit.lmy.entity.Activity;
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
 * @since 2018-06-04
 */
@Component
public interface ActivityMapper extends BaseMapper<Activity> {
    @Select("SELECT * FROM t_group as a ,t_activity as b WHERE a.group_id = b.activity_group AND a.course_id = #{courseId}")
    @Results({
            @Result(column="activity_id", property="activityId"),
            @Result(column="publish_user_account",property="publishUserAccount"),
            @Result(column="activity_type", property="activityType" ),
            @Result(column="activity_title", property="activityTitle"),
            @Result(column="activity_group" ,property="activityGroup"),
            @Result(column="activity_experience", property="activityExperience"),
            @Result(column="activity_info", property="activityInfo"),
            @Result(column="activity_resources", property="activityResources"),
            @Result(column="activity_status", property="activityStatus"),
            @Result(column="activity_start_time", property="activityStartTime" ),
            @Result(column="activity_end_time", property="activityEndTime"),
    })
    List<Activity> getActivity(@Param("courseId")Integer id) ;

    @Select("SELECT MAX(activity_id) FROM t_activity")
    Integer getActivityId();
}
