package com.niit.lmy.mapper;

import com.niit.lmy.entity.Resource;
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
 * @since 2018-06-05
 */
@Component
public interface ResourceMapper extends BaseMapper<Resource> {
    @Select("SELECT * FROM t_group as a ,t_resource as b WHERE a.group_id = b.resource_group AND a.course_id = #{courseId}")
    @Results({
            @Result(column="resource_id",property="resourceId"),
            @Result(column="publish_user_account",property="publishUserAccount"),
            @Result(column="resource_group" ,property="resourceGroup"),
            @Result(column="resource_experience" ,property="resourceExperience"),
            @Result(column="resource_knowledge", property="resourceKnowledge"),
            @Result(column="resource_ask" ,property="resourceAsk"),
            @Result(column="resource_status" ,property="resourceStatus"),
            @Result(column="resource_type",property="resourceType"),
            @Result(column="resource_url", property="resourceUrl"),
            @Result(column="resource_publish_time", property="resourcePublishTime")
    })
    List<Resource> getResource(@Param("courseId")Integer courseId) ;

    @Select("SELECT MAX(resource_id) FROM t_resource")
    Integer getResourceId();
}
