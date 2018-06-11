package com.niit.lmy.mapper;

import com.niit.lmy.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void getRole() {
        Role role = roleMapper.selectById(1);
        System.out.println(role);
//        List<Role> list = roleMapper.getRole("15195226887",1);
//        list.forEach(role -> System.out.println(role));
    }
}