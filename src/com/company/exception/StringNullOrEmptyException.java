package com.company.exception;

/**
 * Class exception with <b>message</b> property
 *
 * @author Dmitriy Orlov
 */
public class StringNullOrEmptyException extends Exception {
    /**
     * message field
     */
    private String message;

    /**
     * Constructor for creating a new object (StringNullOrEmptyException) without values
     */
    public StringNullOrEmptyException() {
    }

    /**
     * Constructor creating a new object (StringNullOrEmptyException) with certain values
     *
     * @param message exception message
     */
    public StringNullOrEmptyException(String message) {
        this.message = message;
    }

    /**
     * Method for getting the exception message
     *
     * @return exception message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
