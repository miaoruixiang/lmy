package com.niit.lmy.mapper;

import com.niit.lmy.entity.ActivityWorkRefer;
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
public interface ActivityWorkReferMapper extends BaseMapper<ActivityWorkRefer> {
    @Select("SELECT MAX(work_refer_id) FROM t_activity_work_refer")
    Integer getWorkReferId();
}
