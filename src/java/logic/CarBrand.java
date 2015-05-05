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
import javax.persistence.Table;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "car_brand")
public class CarBrand implements Serializable {

    @Id
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "manufacturer_country")
    private String manufacturerCountry;

    public CarBrand() {
    }

    public CarBrand(String carBrand, String manufacturerCountry) {
        this.carBrand = carBrand;
        this.manufacturerCountry = manufacturerCountry;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    @Override
    public String toString() {
        return "CarBrand:" + carBrand + "  ManufacturerCountry:" + manufacturerCountry;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.carBrand);
        hash = 13 * hash + Objects.hashCode(this.manufacturerCountry);
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
        final CarBrand other = (CarBrand) obj;
        if (!Objects.equals(this.carBrand, other.carBrand)) {
            return false;
        }
        if (!Objects.equals(this.manufacturerCountry, other.manufacturerCountry)) {
            return false;
        }
        return true;
    }

}
