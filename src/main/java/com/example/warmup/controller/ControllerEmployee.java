package com.example.warmup.controller;

import com.example.warmup.model.Employee;
import com.example.warmup.repository.IEmployeeRepository;
import com.example.warmup.service.IServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class ControllerEmployee {
    @Autowired
    IServiceEmployee serviceEmployee;

    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listEmployee", serviceEmployee.findAll());
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam(name = "search") String search){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listEmployee",iEmployeeRepository.findAllByNameContaining(search));
        return modelAndView;
    }

    @PostMapping("/check")
    public ModelAndView check(@RequestParam(name = "min") double min,@RequestParam(name = "max") double max){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listEmployee",iEmployeeRepository.findAllBySalaryBetween(min,max));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Employee employee) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        serviceEmployee.save(employee);
        return modelAndView;
    }


    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("employeeEdit", serviceEmployee.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Employee employee) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        serviceEmployee.save(employee);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("employeeDelete", serviceEmployee.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(Employee employee) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        serviceEmployee.remove(employee.id);
        return modelAndView;
    }



}
