package com.niit.lmy.mapper;

import com.niit.lmy.entity.UserLogin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author miao
 * @since 2018-05-31
 */
@Component
public interface UserLoginMapper extends BaseMapper<UserLogin> {

}
