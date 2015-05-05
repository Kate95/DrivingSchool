/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    
    @Column(name = "student_ID")
    private Integer studentID;

    @ManyToOne
    @JoinColumn(name = "group_ID")
    private StudyGroup studyGroup;

    @Column(name = "student_name")
    private String studentName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Student() {
    }

    public Student(Integer studentID, StudyGroup studyGroup, String studentName, String phoneNumber, String address, Date dateOfBirth, String login, String password) {
        this.studentID = studentID;
        this.studyGroup = studyGroup;
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.login = login;
        this.password = password;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return studentName + "  PhoneNumber:" + phoneNumber + "  Address:" + address + "  DateOfBirth:" + dateOfBirth + " StudyGroup:" + studyGroup.getGroupNumber();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.studentID);
        hash = 17 * hash + Objects.hashCode(this.studentName);
        hash = 17 * hash + Objects.hashCode(this.phoneNumber);
        hash = 17 * hash + Objects.hashCode(this.login);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
        if (!Objects.equals(this.studyGroup, other.studyGroup)) {
            return false;
        }
        if (!Objects.equals(this.studentName, other.studentName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if(this.dateOfBirth.getTime()!=other.dateOfBirth.getTime()){
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
