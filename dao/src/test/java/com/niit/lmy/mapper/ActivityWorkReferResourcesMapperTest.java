package com.niit.lmy.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.ActivityWorkReferResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ActivityWorkReferResourcesMapperTest {
    @Autowired
    private ActivityWorkReferResourcesMapper activityWorkReferResourcesMapper;

    @Test
    public void get(){
        List<ActivityWorkReferResources> list = activityWorkReferResourcesMapper.selectList(
                new EntityWrapper<ActivityWorkReferResources>().eq("work_refer_id",10)
        );
        list.forEach(activityWorkReferResources -> System.out.println(activityWorkReferResources.getWorkReferResourceId()));
    }

}