package com.bytesw.school.bs.dao.Impl;

import com.bytesw.school.bs.dao.StudentRepositoryCustom;
import com.bytesw.school.eis.bo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepositoryCustom {

    private EntityManager em;

    @Autowired
    public StudentRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Student> searchByName(String firstname) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.firstname = :firstname ORDER BY s.id DESC");
        query.setParameter("firstname", firstname);
        return (List<Student>) query.getResultList();
    }
}
