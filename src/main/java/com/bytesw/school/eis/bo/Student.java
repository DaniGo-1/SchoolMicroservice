package com.bytesw.school.eis.bo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

//    @GeneratedValue(strategy = GenerationType.AUTO);
//    Tipo UUID -> Hibernate genera una identificacion de forma "8dd5f315-9788-4d00-87bb-10eed9eff566".

    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private int grade;
    private String section;
    private String user;
    private String password;

//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Assignment> assignments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Assignment> getAssignments() {
//        return assignments;
//    }
//
//    public void setAssignments(List<Assignment> assignments) {
//        this.assignments = assignments;
//    }
}
