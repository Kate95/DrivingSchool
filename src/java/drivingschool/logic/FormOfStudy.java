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
import javax.persistence.Table;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "form_of_study")
public class FormOfStudy implements Serializable {

    @Id
    @Column(name = "form_of_study")
    private String formOfStudy;
    @Column(name = "cost_of_education")
    private Integer costOfEducation;
    @Column(name = "hours_for_theory")
    private Integer hoursForTheory;
    @Column(name = "hours_for_driving")
    private Integer hoursForDriving;

    public FormOfStudy() {
    }

    public FormOfStudy(String formOfStudy, Integer costOfEducation, Integer hoursForTheory, Integer hoursForDriving) {
        this.formOfStudy = formOfStudy;
        this.costOfEducation = costOfEducation;
        this.hoursForTheory = hoursForTheory;
        this.hoursForDriving = hoursForDriving;
    }

    public void setFormOfStudy(String formOfStudy) {
        this.formOfStudy = formOfStudy;
    }

    public void setCostOfEducation(Integer costOfEducation) {
        this.costOfEducation = costOfEducation;
    }

    public void setHoursForTheory(Integer hoursForTheory) {
        this.hoursForTheory = hoursForTheory;
    }

    public void setHoursForDriving(Integer hoursForDriving) {
        this.hoursForDriving = hoursForDriving;
    }

    public String getFormOfStudy() {
        return formOfStudy;
    }

    public Integer getCostOfEducation() {
        return costOfEducation;
    }

    public Integer getHoursForTheory() {
        return hoursForTheory;
    }

    public Integer getHoursForDriving() {
        return hoursForDriving;
    }

    @Override
    public String toString() {
        return formOfStudy + " CostOfEducation:" + costOfEducation + " HoursForTheory:" + hoursForTheory + "  HoursForDriving:" + hoursForDriving;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.formOfStudy);
        hash = 43 * hash + Objects.hashCode(this.costOfEducation);
        hash = 43 * hash + Objects.hashCode(this.hoursForDriving);
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
        final FormOfStudy other = (FormOfStudy) obj;
        if (!Objects.equals(this.formOfStudy, other.formOfStudy)) {
            return false;
        }
        if (!Objects.equals(this.costOfEducation, other.costOfEducation)) {
            return false;
        }
        if (!Objects.equals(this.hoursForTheory, other.hoursForTheory)) {
            return false;
        }
        if (!Objects.equals(this.hoursForDriving, other.hoursForDriving)) {
            return false;
        }
        return true;
    }

}
