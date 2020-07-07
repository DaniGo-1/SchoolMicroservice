package com.bytesw.school.bs.dao;


import com.bytesw.school.eis.bo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Course getCourse(@Param("id") int id);

}
