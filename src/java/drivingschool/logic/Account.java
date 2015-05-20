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
import javax.persistence.Table;

/**
 *
 * @author Kate
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @Column(name = "account_number")
    private Integer accountNumber;
    @Column(name = "amount_of_money")
    private Integer amountOfMoney;

    @ManyToOne
    @JoinColumn(name = "student_ID")
    private Student student;

    public Account() {
    }

    public Account(Integer accountNumber, Integer amountOfMoney, Student student) {
        this.accountNumber = accountNumber;
        this.amountOfMoney = amountOfMoney;
        this.student = student;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public Student getStudent() {
        return student;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Number: " + accountNumber + "  Money:" + amountOfMoney + " Student:" + student.getStudentName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.accountNumber);
        hash = 53 * hash + Objects.hashCode(this.amountOfMoney);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        if (!Objects.equals(this.amountOfMoney, other.amountOfMoney)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return true;
    }
}
