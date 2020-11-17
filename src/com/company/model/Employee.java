package com.company.model;

import com.company.exception.StringNullOrEmptyException;

import java.io.Serializable;


/**
 * Employee class with <b>manager</b> property
 *
 * @author Dmitriy Orlov
 */
public class Employee extends Worker implements Serializable {

    /**
     * manager field
     */
    private String manager;

    /**
     * Constructor creating a new object (employee) with certain values
     *
     * @param firstName   employee's firstname
     * @param lastname    employee's lastname
     * @param yearOfBirth employee's year of birth
     * @param phone       employee's phone number
     * @param manager     employee's manager
     * @throws StringNullOrEmptyException firstname, lastname, phone or manager
     *                                    *                                    arguments are null or have an empty value
     */
    public Employee(String firstName, String lastname, short yearOfBirth, String phone, String manager)
            throws StringNullOrEmptyException {
        super(firstName, lastname, yearOfBirth, phone);
        setManager(manager);
    }

    /**
     * Method for getting the employee's manager
     *
     * @return employee's manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Method that set the employee's manager
     *
     * @param manager employee's manager
     * @throws StringNullOrEmptyException manager argument is null or has an empty value
     */
    public void setManager(String manager) throws StringNullOrEmptyException {
        if (manager == null || manager.isEmpty()) {
            throw new StringNullOrEmptyException("The manager field must not be empty or null");
        }
        this.manager = manager;
    }

    /**
     * Method forms a string that "textually represents" employee
     *
     * @return a string representation of the employee.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "manager='" + manager + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastname='" + super.getLastname() + '\'' +
                ", yearOfBirth=" + super.getYearOfBirth() +
                ", phone='" + super.getPhone() + '\'' +
                '}';
    }
}
