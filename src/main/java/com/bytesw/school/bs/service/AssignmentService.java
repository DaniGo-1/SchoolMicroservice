package com.bytesw.school.bs.service;

import com.bytesw.school.eis.bo.Assignment;
import com.bytesw.school.eis.dto.AssignmentDTO;

import java.util.List;

public interface AssignmentService {

    Assignment getAssignment(int id);

    List<Assignment> searchAllAssign();

    Assignment createAssignment(Assignment assignment);

    Assignment updateAssignment(Assignment assignment);

    Assignment deleteAssignment(int id);
}
