package com.bytesw.school.bs.service;

import com.bytesw.school.eis.bo.Course;

import java.util.List;

public interface CourseService {

    Course getCourse(int id);

    List<Course> getCourseAll();

    Course createCourse(Course course);

    Course updateCourse(Course course);

    Course deleteCourse(int id);
}
