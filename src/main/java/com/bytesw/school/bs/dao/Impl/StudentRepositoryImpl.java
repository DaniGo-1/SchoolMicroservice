package com.bytesw.school.bs.dao.Impl;

import com.bytesw.school.bs.dao.StudentRepositoryCustom;
import com.bytesw.school.eis.bo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentRepositoryImpl implements StudentRepositoryCustom {

    private EntityManager em;

    @Autowired
    public StudentRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Student searchByName(String firstname) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.firstname = :firstname");
        query.setParameter("firstname", firstname);
        return (Student) query.getSingleResult();
    }
}
