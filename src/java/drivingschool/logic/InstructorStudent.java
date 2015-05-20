/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.logic;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "instructor_student")
public class InstructorStudent implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_ID")
    private Student student;
    @Id
    @ManyToOne
    @JoinColumn(name = "instructor_ID")
    private Instructor instructor;

    public InstructorStudent() {
    }

    public InstructorStudent(Student student, Instructor instructor) {
        this.student = student;
        this.instructor = instructor;
    }

    public Student getStudent() {
        return student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Student:" + student.getStudentName() + "  Instructor:" + instructor.getInstructorName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.student);
        hash = 71 * hash + Objects.hashCode(this.instructor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InstructorStudent other = (InstructorStudent) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.instructor, other.instructor)) {
            return false;
        }
        return true;
    }

}
