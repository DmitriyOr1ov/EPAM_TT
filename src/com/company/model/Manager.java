package com.company.model;

import com.company.exception.StringNullOrEmptyException;

import java.io.Serializable;

/**
 * Manager class with <b>departmentNumber</b> property
 *
 * @author Dmitriy Orlov
 */
public class Manager extends Worker implements Serializable {
    /**
     * department number field
     */
    private String departmentNumber;

    /**
     * Constructor creating a new object (manager) with certain values
     *
     * @param firstName        manager's firstname
     * @param lastname         manager's lastname
     * @param yearOfBirth      manager's year of birth
     * @param phone            manager's phone number
     * @param departmentNumber manager's department number
     * @throws StringNullOrEmptyException firstname, lastname, phone or departmentNumber
     *                                    arguments are null or have an empty value
     */
    public Manager(String firstName, String lastname, short yearOfBirth, String phone, String departmentNumber) throws StringNullOrEmptyException {
        super(firstName, lastname, yearOfBirth, phone);
        setDepartmentNumber(departmentNumber);
    }

    /**
     * Method for getting the manager's department number
     *
     * @return manager's department number
     */
    public String getDepartmentNumber() {
        return departmentNumber;
    }

    /**
     * Method that set the worker's department number
     *
     * @param departmentNumber manager's department number
     * @throws StringNullOrEmptyException department number argument is null or has an empty value
     */
    public void setDepartmentNumber(String departmentNumber) throws StringNullOrEmptyException {
        if (departmentNumber == null || departmentNumber.isEmpty()) {
            throw new StringNullOrEmptyException("The department number field must not be empty or null");
        }
        this.departmentNumber = departmentNumber;
    }

    /**
     * Method forms a string that "textually represents" manager
     *
     * @return a string representation of the manager.
     */
    @Override
    public String toString() {
        return "Manager{" +
                "departmentNumber='" + departmentNumber + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastname='" + super.getLastname() + '\'' +
                ", yearOfBirth=" + super.getYearOfBirth() +
                ", phone='" + super.getPhone() + '\'' +
                '}';
    }
}
