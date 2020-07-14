package com.bytesw.school.bs.dao;

import com.bytesw.school.eis.bo.Assignment;
import com.bytesw.school.eis.dto.AssignmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    @Query("FROM Assignment a , Course c , Student s WHERE a.course.id = c.id AND a.student.id = s.id ORDER BY a.id DESC")
    List<Assignment> searchAllAssign();

}
