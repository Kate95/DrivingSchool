/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
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
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @Column(name = "car_number")
    private Integer carNumber;
    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    @ManyToOne
    @JoinColumn(name = "instructor_ID")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "car_brand")
    private CarBrand carBrand;

    public Car() {
    }

    public Car(Integer carNumber, Integer yearOfManufacture, Instructor instructor, CarBrand carBrand) {
        this.carNumber = carNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.instructor = instructor;
        this.carBrand = carBrand;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return "Number:" + carNumber + "  CarBrand:" + carBrand.getCarBrand() + "  YearOfManufacture:" + yearOfManufacture + "  Instructor:" + instructor.getInstructorName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.carNumber);
        hash = 79 * hash + Objects.hashCode(this.yearOfManufacture);
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
        final Car other = (Car) obj;
        if (!Objects.equals(this.carNumber, other.carNumber)) {
            return false;
        }
        if (!Objects.equals(this.yearOfManufacture, other.yearOfManufacture)) {
            return false;
        }
        if (!Objects.equals(this.instructor, other.instructor)) {
            return false;
        }
        if (!Objects.equals(this.carBrand, other.carBrand)) {
            return false;
        }
        return true;
    }

}
