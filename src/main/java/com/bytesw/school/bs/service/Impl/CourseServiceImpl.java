package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.CourseRepository;
import com.bytesw.school.bs.service.CourseService;
import com.bytesw.school.eis.bo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourse(int id) {
        Course response = this.courseRepository.findOne(id);
        return response;
    }

    @Override
    public List<Course> getCourseAll() {
        List<Course> response = this.courseRepository.findAll();
        Collections.reverse(response);
        return response;
    }

    @Override
    public Course createCourse(Course course) {
        Course response = this.courseRepository.save(course);
        return response;
    }
}
