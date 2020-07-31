package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.AssignmentRepository;
import com.bytesw.school.bs.service.AssignmentService;
import com.bytesw.school.eis.bo.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository){
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public Assignment getAssignment(int id) {
        Optional<Assignment> response = this.assignmentRepository.findById(id);
        return response.isPresent() ? response.get() : new Assignment();
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
        Optional<Assignment> response = this.assignmentRepository.findById(id);
        this.assignmentRepository.deleteById(id);
        return response.isPresent() ? response.get() : new Assignment();
    }


}
