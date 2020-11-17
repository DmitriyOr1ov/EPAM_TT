package com.company.model;

import com.company.exception.StringNullOrEmptyException;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.Year;

/**
 * Worker class with <b>firstname</b>, <b>lastname</b>,
 * <b>yearOfBirth</b> and <b>phone</b> properties
 *
 * @author Dmitriy Orlov
 */
public class Worker implements Serializable {
    /**
     * firstname field
     */
    private String firstName;
    /**
     * lastname field
     */
    private String lastname;
    /**
     * yearOfBirth field
     */
    private short yearOfBirth;
    /**
     * phone field
     */
    private String phone;

    /**
     * Constructor creating a new object (worker) with certain values
     *
     * @param firstName   worker's firstname
     * @param lastname    worker's lastname
     * @param yearOfBirth worker's year of birth
     * @param phone       worker's phone
     * @throws StringNullOrEmptyException firstname, lastname, phone arguments are null or have an empty value
     */
    public Worker(String firstName, String lastname, short yearOfBirth, String phone) throws StringNullOrEmptyException {
        setFirstName(firstName);
        setLastname(lastname);
        setYearOfBirth(yearOfBirth);
        setPhone(phone);
    }

    /**
     * Method for getting the worker's firstname
     *
     * @return worker's firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method that set the worker's firstname
     *
     * @param firstName worker's firstname
     * @throws StringNullOrEmptyException firstname argument is null or has an empty value
     */
    public void setFirstName(String firstName) throws StringNullOrEmptyException {
        if (firstName == null || firstName.isEmpty()) {
            throw new StringNullOrEmptyException("The firstname field must not be empty or null");
        } else {
            this.firstName = firstName;
        }
    }

    /**
     * Method for getting the worker's lastname
     *
     * @return worker's lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Method that set the worker's lastname
     *
     * @param lastname worker's lastname
     * @throws StringNullOrEmptyException lastname argument is null or has an empty value
     */
    public void setLastname(String lastname) throws StringNullOrEmptyException {
        if (lastname == null || lastname.isEmpty()) {
            throw new StringNullOrEmptyException("The lastname field must not be empty or null");
        } else {
            this.lastname = lastname;
        }
    }

    /**
     * Method for getting the worker's year of birth
     *
     * @return worker's year of birth
     */
    public short getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Method that set the worker's year of birth
     *
     * @param yearOfBirth worker's year of birth
     */
    public void setYearOfBirth(short yearOfBirth) {
        if (yearOfBirth < 1900 || yearOfBirth > Year.now().getValue()) {
            throw new DateTimeException("Please, enter correct year");
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    /**
     * Method for getting the worker's phone number
     *
     * @return worker's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method that set the worker's phone number
     *
     * @param phone
     * @throws StringNullOrEmptyException phone argument is null or has an empty value
     */
    public void setPhone(String phone) throws StringNullOrEmptyException {
        if (phone == null || phone.isEmpty()) {
            throw new StringNullOrEmptyException("The phone field must not be empty or null");
        } else {
            this.phone = phone;
        }
    }

    /**
     * Method forms a string that "textually represents" worker
     *
     * @return a string representation of the worker.
     */
    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", phone='" + phone + '\'' +
                '}';
    }
}
