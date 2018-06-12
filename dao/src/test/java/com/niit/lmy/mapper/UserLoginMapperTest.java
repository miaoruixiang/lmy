package com.niit.lmy.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.UserLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class UserLoginMapperTest {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Test
    public void selectAll(){

    }

    @Test
    public void updatePassword(){
        List<UserLogin> userLogins = userLoginMapper.selectList(
                new EntityWrapper<UserLogin>().eq("user_account", "15195226887")
        );
        System.out.println(userLogins.get(0));
    }
}