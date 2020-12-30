package com.o2xp.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TimesheetService<T> {
    public List<T> findAll();
    public Optional<T> findById(Long id);
    public T save(T o);
    public T update(Long id, T o);
    public void delete(Long id);
}
