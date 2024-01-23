package com.example.warmup.service;

import com.example.warmup.model.Employee;
import com.example.warmup.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServiceEmployee implements IServiceEmployee {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> findAll(){
        return iEmployeeRepository.findAll();
    }
    @Override
    public Optional<Employee> findById(Long id){
        return iEmployeeRepository.findById(id);
    }
    @Override
    public void save(Employee employee){
        iEmployeeRepository.save(employee);
    }
    @Override
    public void remove(Long id){
        iEmployeeRepository.deleteById(id);
    }
    @Override
    public void update(Employee employee){
        iEmployeeRepository.save(employee);
    }

//    @Override
//    public List<Employee> listAll(String keyword){
//        if (keyword!=null){
//            return iEmployeeRepository.findAll(keyword);
//        }
//        return iEmployeeRepository.findAll();
//    }


    @Override
    public List<Employee> searchByName(String name){
        return iEmployeeRepository.findAllByNameContaining(name);
    }
}
