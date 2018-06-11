package com.niit.lmy.mapper;

import com.niit.lmy.entity.ActivityBrainStormingRefer;
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
public interface ActivityBrainStormingReferMapper extends BaseMapper<ActivityBrainStormingRefer> {
//    @Select("SELECT * FROM t_activity_brain_storming_refer WHERE activity_id = #{activityId} AND refer_user_account = #{account}")
//    @Results({
//            @Result(column="storming_refer_id", property="stormingReferId"),
//            @Result(column="activity_id", property="activityId"),
//            @Result(column="refer_user_account", property="referUserAccount"),
//            @Result(column="storming_refer_info", property="stormingReferInfo"),
//            @Result(column="storming_refer_img", property="stormingReferImg"),
//            @Result(column="storming_refer_time", property="stormingReferTime")
//    })
//    List<ActivityBrainStormingRefer> getStormRefer(@Param("activityId") Integer activityId,@Param("account") String account);
}
