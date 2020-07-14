package com.bytesw.school.bs.dao;

import com.bytesw.school.eis.bo.Student;

import java.util.List;

public interface StudentRepositoryCustom {

    List<Student> searchByName(String firstname);

}
