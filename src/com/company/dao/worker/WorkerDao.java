package com.company.dao.worker;

import com.company.dao.Dao;
import com.company.model.Worker;

import java.util.List;

/**
 * Dao for working with Worker entity {@link Worker}
 *
 * @author Dmitriy Orlov
 */
public interface WorkerDao extends Dao<Worker> {
    /**
     * Method for search workers by firstname
     *
     * @param firstname firstname to search for
     * @return a list of workers whose name matches with <b>firstname></b> argument
     */
    List<Worker> findByFirstname(String firstname);

    /**
     * Method for search workers by lastname
     *
     * @param lastname lastname to search for
     * @return a list of workers whose name matches with <b>lastname></b> argument
     */
    List<Worker> findByLastname(String lastname);

    /**
     * Method for search worker by phone
     *
     * @param phone phone number to search for
     * @return the worker who has phone number matches with <b>phone</b> argument
     */
    Worker findByPhone(String phone);
}
