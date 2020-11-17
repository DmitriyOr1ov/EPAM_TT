package com.company.dao;

import java.util.List;

/**
 * Dao for working with <T> entity
 * @param <T> the entity that the class will be parameterized with
 */
public interface Dao<T> {
    /**
     * Method to add a new <T>element
     * @param adr object with <T> type
     */
    void insert(T adr);

    /**
     * Method to delete <T> element
     * @param index index of element <T>
     */
    void delete(int index);

    /**
     * Method to get all elements <T>
     *
     * @return list of <T> elements
     */
    List<T> getAll();
}
