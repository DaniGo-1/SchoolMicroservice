package com.bytesw.school.bs.controller;

import com.bytesw.school.bs.service.CourseService;
import com.bytesw.school.eis.bo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        Course response = this.courseService.getCourse(id);
        return new ResponseEntity<Course>(response, HttpStatus.OK);
    }

}
