package com.example.warmup.service;

import com.example.warmup.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IServiceEmployee {
    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    void update(Employee employee);

//    List<Employee> listAll(String keyword);

    List<Employee> searchByName(String keyword);
}
