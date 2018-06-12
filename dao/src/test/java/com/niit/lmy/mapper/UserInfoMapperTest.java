package com.niit.lmy.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.Group;
import com.niit.lmy.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void selectAll(){
//        List<UserInfo> users = userInfoMapper.selectList(new EntityWrapper<>());
//        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void update(){
        String[] groupName = new String[]{"00.全课", "01.第一单元","02.第二单元","03.第三单元"};
        for (int j = 0;j < groupName.length;j ++){
            Group group = new Group();
            group.setCourseId(1);
            group.setGroupName(groupName[j]);
            System.out.println(group);
        }
    }
}