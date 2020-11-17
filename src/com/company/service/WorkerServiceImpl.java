package com.company.service;

import com.company.dao.worker.WorkerDao;
import com.company.dao.worker.WorkerDaoImpl;
import com.company.model.Worker;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation service for working with Worker {@link Worker}
 *
 * @author Dmitriy Orlov
 */
public class WorkerServiceImpl implements WorkerService {
    WorkerDao workerDao = new WorkerDaoImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Worker worker) {
        if (worker != null) {

            if (findAll().stream().anyMatch(x -> x.getPhone().equals(worker.getPhone()))) {
                System.out.println("A worker with this phone number is already exist in the notebook");
            } else {
                workerDao.insert(worker);
                System.out.println("Success");
            }
        } else {
            System.out.println("You can't add a null value");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        try {
            workerDao.delete(index);
            System.out.println("Success");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Please, enter the correct value");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> findAll() {
        return workerDao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> findByFirstname(String firstname) {
        return workerDao.findByFirstname(firstname);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> findByLastname(String lastname) {
        return workerDao.findByLastname(lastname);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Worker findByPhone(String phone) {
        return workerDao.findByPhone(phone);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> sortByLastname() {
        return findAll().
                stream().
                sorted((Comparator.comparing(Worker::getLastname))).
                collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> sortByYear() {
        return findAll().
                stream().
                sorted((Comparator.comparing(Worker::getYearOfBirth))).
                collect(Collectors.toList());
    }
}
