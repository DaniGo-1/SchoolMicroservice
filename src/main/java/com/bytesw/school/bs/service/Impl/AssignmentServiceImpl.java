package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.AssignmentRepository;
import com.bytesw.school.bs.service.AssignmentService;
import com.bytesw.school.eis.bo.Assignment;
import com.bytesw.school.eis.dto.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository){
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public Assignment getAssignment(int id) {
        Assignment response = this.assignmentRepository.findOne(id);
        return response;
    }

    @Override
    public List<Assignment> searchAllAssign() {
        List<Assignment> response = this.assignmentRepository.findAll();
        Collections.reverse(response);
        return response;
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        Assignment response = this.assignmentRepository.save(assignment);
        return response;
    }

    @Override
    public Assignment updateAssignment(Assignment assignment) {
        Assignment response = this.assignmentRepository.save(assignment);
        return response;
    }

    @Override
    public Assignment deleteAssignment(int id) {
        Assignment response = this.assignmentRepository.findOne(id);
        this.assignmentRepository.delete(id);
        return response;
    }


}
