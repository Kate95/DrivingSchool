/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.logic;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "exam")
@NamedQueries({        
        @NamedQuery(name="Exam.readByExamNumberAndStudentID",query="SELECT ex FROM Exam ex WHERE ex.examNumber=:examNumber AND ex.student.studentID=:studentID")
})
public class Exam implements Serializable {

    @Id
    @Column(name = "exam_number")
    private Integer examNumber;
    @Id
    @ManyToOne
    @JoinColumn(name = "student_ID")
    private Student student;

    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "exam_type")
    private ExamType examType;

    public Exam() {
    }

    public Exam(Integer examNumber, Student student, Integer value, ExamType examType) {
        this.examNumber = examNumber;
        this.student = student;
        this.value = value;
        this.examType = examType;
    }

    public Integer getExamNumber() {
        return examNumber;
    }

    public Student getStudent() {
        return student;
    }

    public Integer getValue() {
        return value;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamNumber(Integer examNumber) {
        this.examNumber = examNumber;
    }

    public void setStudent(Student student) {//было setStudentID()
        this.student = student;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    @Override
    public String toString() {
        return "Number:" + examNumber + " Student:" + student.getStudentName() + "  Value:" + value + "  Type:" + examType.getExamType();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.examNumber);
        hash = 29 * hash + Objects.hashCode(this.student);
        hash = 29 * hash + Objects.hashCode(this.value);
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
        final Exam other = (Exam) obj;
        if (!Objects.equals(this.examNumber, other.examNumber)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.examType, other.examType)) {
            return false;
        }
        return true;
    }

}
