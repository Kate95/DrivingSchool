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
import javax.persistence.Table;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

    @Id
    @Column(name = "instructor_ID")
    private Integer instructorID;
    @Column(name = "instructor_name")
    private String instructorName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    public Instructor() {
    }

    public Instructor(Integer instructorID, String instructorName, String phoneNumber, Date dateOfBirth) {
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return instructorName + " PhoneNumber:" + phoneNumber + "  DateOfBirth:" + dateOfBirth;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.instructorID);
        hash = 71 * hash + Objects.hashCode(this.instructorName);
        hash = 71 * hash + Objects.hashCode(this.dateOfBirth);
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
        final Instructor other = (Instructor) obj;
        if (!Objects.equals(this.instructorID, other.instructorID)) {
            return false;
        }
        if (!Objects.equals(this.instructorName, other.instructorName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if(this.dateOfBirth.getTime()!=other.dateOfBirth.getTime()){
            return false;
        }
        return true;
    }

}
