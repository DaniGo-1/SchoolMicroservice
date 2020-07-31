package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.StudentRepository;
import com.bytesw.school.bs.service.StudentService;
import com.bytesw.school.eis.bo.Student;
import com.bytesw.school.eis.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> response = this.studentRepository.findAll();
        Collections.reverse(response);
        return response;
    }

    @Override
    public StudentDTO getStudent(int id) {
        Student student = this.studentRepository.getOne(id);
        StudentDTO response = new StudentDTO(student.getId(),student.getFirstname(),
                                        student.getLastname(),student.getAge(),student.getGrade(),
                                        student.getSection(),student.getUser());
        return response;
    }

    @Override
    public StudentDTO saveStudent(Student student) {
        Student student1 = this.studentRepository.save(student);
        StudentDTO response = new StudentDTO(student1.getId(),student1.getFirstname(),
                student1.getLastname(),student1.getAge(),student1.getGrade(),
                student1.getSection(),student1.getUser());
        return response;
    }

    @Override
    public StudentDTO updateStudent(Student student) {
        Student student1 = this.studentRepository.save(student);
        StudentDTO response = new StudentDTO(student1.getId(),student1.getFirstname(),
                student1.getLastname(),student1.getAge(),student1.getGrade(),
                student1.getSection(),student1.getUser());
        return response;
    }

    @Override
    public StudentDTO deleteStudent(int id) {
        Student student = this.studentRepository.getOne(id);
        this.studentRepository.deleteById(id);
        StudentDTO response = new StudentDTO(student.getId(),student.getFirstname(),
                student.getLastname(),student.getAge(),student.getGrade(),
                student.getSection(),student.getUser());
        return response;
    }

    @Override
    public int updateGrade(int id, int grade) {
        int response = this.studentRepository.updateGrade(id, grade);
        return response;
    }

    @Override
    public int updateGradeBySec(String section, int grade) {
        int response = this.studentRepository.updateGradeBySec(section, grade);
        return response;
    }

    @Override
    public int delByGrade(int grade) {
        int response = this.studentRepository.delByGrade(grade);
        return response;
    }

    @Override
    public List<Student> byGrade(int grade) {
        List<Student> response = this.studentRepository.byGrade(grade);
        return response;
    }

    @Override
    public List<Student> byGradeAndSection(int grade, String section) {
        List<Student> response = this.studentRepository.byGradeAndSection(grade, section);
        return response;
    }

    @Override
    public List<Student> byThreeParams(int age, int grade, String section) {
        List<Student> response = this.studentRepository.byThreeParams(age, grade, section);
        return response;
    }

    @Override
    public List<Student> searchByName(String firstname) {
        List<Student> response = this.studentRepository.searchByName(firstname);
        return response;
    }
}
