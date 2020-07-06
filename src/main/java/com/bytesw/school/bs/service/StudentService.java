package com.bytesw.school.bs.service;

import com.bytesw.school.eis.bo.Student;
import com.bytesw.school.eis.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO getStudent(int id);

    StudentDTO saveStudent(Student student);

    StudentDTO updateStudent(Student student);

    StudentDTO deleteStudent(int id);

    int updateGrade(int id, int grade);

    int updateGradeBySec(String section, int grade);

    List<Student> byGrade(int grade);

    List<Student> byGradeAndSection(int grade, String section);

    List<Student> byThreeParams(int age, int grade, String section);
}
