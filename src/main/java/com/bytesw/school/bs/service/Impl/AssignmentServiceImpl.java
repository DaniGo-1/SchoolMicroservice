package com.bytesw.school.bs.service.Impl;

import com.bytesw.school.bs.dao.AssignmentRepository;
import com.bytesw.school.bs.service.AssignmentService;
import com.bytesw.school.eis.bo.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
