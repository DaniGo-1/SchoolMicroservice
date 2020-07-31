package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.CourseRepository;
import com.bytesw.school.bs.service.CourseService;
import com.bytesw.school.eis.bo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourse(int id) {
        Optional<Course>  response = this.courseRepository.findById(id);
        return response.isPresent() ? response.get() : new Course();
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

    @Override
    public Course updateCourse(Course course) {
        Course response = this.courseRepository.save(course);
        return response;
    }

    @Override
    public Course deleteCourse(int id) {
        Optional<Course> response = this.courseRepository.findById(id);
        this.courseRepository.deleteById(id);
        return response.isPresent() ? response.get() : new Course();
    }
}
