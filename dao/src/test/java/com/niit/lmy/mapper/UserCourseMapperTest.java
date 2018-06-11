package com.niit.lmy.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.UserCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class UserCourseMapperTest {
    @Autowired
    private UserCourseMapper userCourseMapper;

    @Test
    public void del() {
        int n = userCourseMapper.delete(
                new EntityWrapper<UserCourse>().eq("course_id",66)
        );
    }

    @Test
    public void getUserCourse() {
        UserCourse userCourse = userCourseMapper.getUserCourse(4,"13951011168");
        System.out.println(userCourse);
    }
    @Test
    public void get() {
        UserCourse userCourse = userCourseMapper.get(2,"15195226887");
        System.out.println(userCourse);
    }

    @Test
    public void getUserCourses() {
        List<UserCourse> list = userCourseMapper.getUserCourses(1);
        list.forEach(userCourse -> System.out.println(userCourse));
    }
}