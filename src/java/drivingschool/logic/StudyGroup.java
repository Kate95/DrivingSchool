/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
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
@Table(name = "study_group")
public class StudyGroup implements Serializable {

    @Id
    @Column(name = "group_ID")
    private Integer groupID;
    @Column(name = "group_number")
    private Integer groupNumber;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "form_of_study")
    private FormOfStudy formOfStudy;

    public StudyGroup() {
    }

    public StudyGroup(int groupID, int groupNumber, Date startDate, Date endDate, FormOfStudy form) {
        this.groupID = groupID;
        this.groupNumber = groupNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.formOfStudy = form;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setFormOfStudy(FormOfStudy formOfStudy) {
        this.formOfStudy = formOfStudy;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public FormOfStudy getFormOfStudy() {
        return formOfStudy;
    }

    @Override
    public String toString() {
        return groupNumber + "  StartDate:" + startDate + "  EndDate:" + endDate + "  formOfStudy:" + formOfStudy.getFormOfStudy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.groupID);
        hash = 59 * hash + Objects.hashCode(this.groupNumber);
        hash = 59 * hash + Objects.hashCode(this.endDate);
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
        final StudyGroup other = (StudyGroup) obj;
        if (!Objects.equals(this.groupNumber, other.groupNumber)) {
            return false;
        }
        if(this.startDate.getTime()!=other.startDate.getTime()){
            return false;
        }
        if(this.endDate.getTime()!=other.endDate.getTime()){
            return false;
        }
        if (!Objects.equals(this.formOfStudy, other.formOfStudy)) {
            return false;
        }
        return true;
    }

}
