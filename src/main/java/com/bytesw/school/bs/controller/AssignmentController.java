package com.bytesw.school.bs.controller;

import com.bytesw.school.bs.service.AssignmentService;
import com.bytesw.school.eis.bo.Assignment;
import com.bytesw.school.eis.dto.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/assignment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssignmentController {

    private AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable int id){
        Assignment response = this.assignmentService.getAssignment(id);
        return new ResponseEntity<Assignment>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> searchAllAssign(){
        List<Assignment> response = this.assignmentService.searchAllAssign();
        return new ResponseEntity<List<Assignment>>(response, HttpStatus.OK);
    }

}
