package com.niit.lmy.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.ActivityBrainStormingRefer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ActivityBrainStormingReferMapperTest {
    @Autowired
    private ActivityBrainStormingReferMapper stormingReferMapper;

    @Test
    public void get(){
        List<ActivityBrainStormingRefer> list = stormingReferMapper.selectList(
                new EntityWrapper<ActivityBrainStormingRefer>().eq("activity_id",3)
                                                                .eq("refer_user_account","15195757885")
        );
        System.out.println(list.get(0));
    }
}