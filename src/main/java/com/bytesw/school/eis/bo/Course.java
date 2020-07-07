package com.bytesw.school.eis.bo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    private int id;
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Assignment> getAssignments() {
//        return assignments;
//    }
//
//    public void setAssignments(List<Assignment> assignments) {
//        this.assignments = assignments;
//    }
}
