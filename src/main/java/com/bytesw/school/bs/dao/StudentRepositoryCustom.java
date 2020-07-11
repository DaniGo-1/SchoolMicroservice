package com.bytesw.school.bs.dao;

import com.bytesw.school.eis.bo.Student;

public interface StudentRepositoryCustom {

    Student searchByName(String firstname);

}
