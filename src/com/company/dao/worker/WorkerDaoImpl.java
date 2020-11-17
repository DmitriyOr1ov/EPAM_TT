package com.company.dao.worker;


import com.company.model.Worker;
import com.company.tools.FileAccess;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Implementation dao for working with Worker entity {@link Worker}
 *
 * @author Dmitriy Orlov
 */
public class WorkerDaoImpl implements WorkerDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> findByFirstname(String firstname) {
        return getAll().stream().
                filter(x -> x.getFirstName().toLowerCase().equals(firstname.toLowerCase())).
                collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> findByLastname(String lastname) {
        return getAll().stream().
                filter(x -> x.getLastname().toLowerCase().equals(lastname.toLowerCase())).
                collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Worker findByPhone(String phone) {
        try {
            return getAll().stream().filter(x -> x.getPhone().equals(phone)).findFirst().get();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(Worker worker) {
        FileAccess fa = new FileAccess();
        List<Worker> workers = getAll();
        workers.add(worker);
        fa.saveToFile(workers);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int index) {
        FileAccess fa = new FileAccess();
        List<Worker> workers = getAll();
        workers.remove(index);
        fa.saveToFile(workers);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> getAll() {
        FileAccess fileAccess = new FileAccess();
        return fileAccess.readFromFile();
    }
}
