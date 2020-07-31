package com.bytesw.school.bs.service;

import com.bytesw.school.eis.bo.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {

    Assignment getAssignment(int id);

    List<Assignment> searchAllAssign();

    Assignment createAssignment(Assignment assignment);

    Assignment updateAssignment(Assignment assignment);

    Assignment deleteAssignment(int id);
}
