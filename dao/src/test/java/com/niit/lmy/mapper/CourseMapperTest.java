package com.niit.lmy.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void getAll() {
//        int id = courseMapper.getCourseId();
//        System.out.println(id);
//        int courseId = 24;
//        Course course = courseMapper.selectById(courseId);
//        System.out.println(course);
//        List<Course> list = courseMapper.selectList(new EntityWrapper<Course>().eq("course_name","java"));
//        List<Course> list = courseMapper.getCourses("15195226887");
//        list.forEach(course -> System.out.println(course));
    }
}