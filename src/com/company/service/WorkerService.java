package com.company.service;

import com.company.model.Worker;

import java.util.List;

/**
 * Service for working with Worker {@link Worker}
 * @author Dmitriy Orlov
 */
public interface WorkerService {
    /**
     * Method to add a new worker
     * @param worker worker
     */
    void add(Worker worker);

    /**
     * Method to delete worker
     * @param index index of worker
     */
    void remove(int index);

    /**
     * Method to get all workers
     * @return list of workers
     */
    List<Worker> findAll();

    /**
     * Method for search workers by firstname
     * @param firstname firstname to search for
     * @return a list of workers whose name matches with <b>firstname></b> argument
     */
    List<Worker> findByFirstname(String firstname);

    /**
     * Method for search workers by lastname
     * @param lastname lastname to search for
     * @return a list of workers whose name matches with <b>lastname></b> argument
     */
    List<Worker> findByLastname(String lastname);

    /**
     * Method for search worker by phone
     * @param phone phone number to search for
     * @return the worker who has phone number matches with <b>phone</b> argument
     */
    Worker findByPhone(String phone);

    /**
     * Method for sorting workers by their lastname
     * @return a list of workers sorted by lastname
     */
    List<Worker> sortByLastname();

    /**
     * Method for sorting workers by their year of birth
     * @return a list of workers sorted by year of birth
     */
    List<Worker> sortByYear();
}
