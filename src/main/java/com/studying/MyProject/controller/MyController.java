package com.studying.MyProject.controller;

import com.studying.MyProject.entity.Employee;
import com.studying.MyProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String sayHello() {
        return "Hello World";
    }
    @RequestMapping("/allEmployees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
