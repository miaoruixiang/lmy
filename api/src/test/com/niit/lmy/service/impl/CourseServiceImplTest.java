package com.niit.lmy.service.impl;

import com.niit.lmy.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class CourseServiceImplTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void getActivityId() {
        int id = courseService.getActivityId();
        System.out.println(id);
    }

    @Test
    public void getWorkReferResourceId() {
        List<Integer> ids = courseService.getWorkReferResourceId(10);
        ids.forEach(integer -> System.out.println(integer));
    }
}