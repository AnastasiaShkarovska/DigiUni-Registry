package ua.university.repository;

import java.util.List;

// Generic repository interface
public interface Repository<T> {
    List<T> findAll();
    void save(T entity);
    void delete(T entity);
}
