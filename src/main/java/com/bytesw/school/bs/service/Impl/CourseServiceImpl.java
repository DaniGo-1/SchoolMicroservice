package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.CourseRepository;
import com.bytesw.school.bs.service.CourseService;
import com.bytesw.school.eis.bo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
