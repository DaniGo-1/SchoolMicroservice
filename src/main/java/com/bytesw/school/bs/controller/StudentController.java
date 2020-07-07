package com.bytesw.school.bs.controller;

import com.bytesw.school.bs.service.StudentService;
import com.bytesw.school.eis.bo.Student;
import com.bytesw.school.eis.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int id){
        StudentDTO response = this.studentService.getStudent(id);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody Student student){
        StudentDTO response = this.studentService.saveStudent(student);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody Student student){
        StudentDTO response = this.studentService.updateStudent(student);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable int id){
        StudentDTO response = this.studentService.deleteStudent(id);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    //Update grade by id
    @PutMapping("/id/{id}/grade/{grade}")
    public ResponseEntity<StudentDTO> updateGrade(@PathVariable int id, @PathVariable int grade){
        this.studentService.updateGrade(id, grade);
        StudentDTO response = this.studentService.getStudent(id);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    //Update grade by section
    @PutMapping("/section/{section}/grade/{grade}")
    public ResponseEntity<List<Student>> updateGradeBySec(@PathVariable String section, @PathVariable int grade){
        this.studentService.updateGradeBySec(section, grade);
        List<Student> response = this.studentService.byGrade(grade);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Delete students by grade
    @DeleteMapping("/delByGrade/{grade}")
    public ResponseEntity<List<Student>> delByGrade(@PathVariable int grade){
        List<Student> response = this.studentService.byGrade(grade);
        this.studentService.delByGrade(grade);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Students by grade
    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Student>> byGrade(@PathVariable int grade){
        List<Student> response = this.studentService.byGrade(grade);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Students by grade and section
    @GetMapping("/{grade}/{section}")
    public ResponseEntity<List<Student>> byGradeAndSection(@PathVariable int grade, @PathVariable String section){
        List<Student> response = this.studentService.byGradeAndSection(grade, section);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Students by age, grade and section
    @GetMapping("/age/{age}/grade/{grade}/section/{section}")
    public ResponseEntity<List<Student>> byThreeParams(@PathVariable int age, @PathVariable int grade, @PathVariable String section){
        List<Student> response = this.studentService.byThreeParams(age,grade, section);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }
}
