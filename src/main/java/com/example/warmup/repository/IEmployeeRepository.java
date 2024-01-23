package com.example.warmup.repository;

import com.example.warmup.model.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {


    List<Employee> findAllByNameContaining(String name);

    List<Employee> findAllBySalaryBetween(double salary, double salary2);

}
