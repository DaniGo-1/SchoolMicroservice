package com.bytesw.school.bs.dao;


import com.bytesw.school.eis.bo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
