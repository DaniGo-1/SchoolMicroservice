package com.bytesw.school.bs.dao;

import com.bytesw.school.eis.bo.Student;
import com.bytesw.school.eis.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //HIBERNATE
    //Update grade by id
    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.grade = :grade WHERE s.id = :id")
    int updateGrade(@Param("id") int id, @Param("grade") int grade);

    //Update grade by section
    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.grade = :grade WHERE s.section = :section")
    int updateGradeBySec(@Param("section") String section, @Param("grade") int grade);

    //Delete by grade
    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.grade = :grade")
    int delByGrade(@Param("grade") int grade);

    //Search by grade
    @Query("SELECT s FROM Student s WHERE s.grade = :grade")
    List<Student> byGrade(@Param("grade") int grade);

    //Search by grade and section
    @Query("SELECT s FROM Student s WHERE s.grade = :grade AND s.section = :section")
    List<Student> byGradeAndSection(@Param("grade") int grade, @Param("section") String section);

    //Search by grade, section and age
    @Query("SELECT s FROM Student s WHERE s.age = :age AND s.grade = :grade AND s.section = :section")
    List<Student> byThreeParams(@Param("age") int age, @Param("grade") int grade, @Param("section") String section);
}
