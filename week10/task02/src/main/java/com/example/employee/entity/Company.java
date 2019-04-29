package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String companyName;
    private String employeesNumber;

    protected Company() {
    }

    public Company(int id, String companyName, String employeesNumber) {
        this.id = id;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmployeesNumber() {
        return employeesNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmployeesNumber(String employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

}
