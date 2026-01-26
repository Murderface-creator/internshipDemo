package com.studying.axenixdemo.service;

import com.studying.axenixdemo.entity.Employee;
import com.studying.axenixdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void printEmployeeByFirstName(String firstName) {
        System.out.println("Поиск по имени: " + firstName);
        List<Employee> employees = employeeRepository.findByFirstName(firstName);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("Поиск завершен");
    }

    public void printEmployeeByLastName(String lastName){
        System.out.println("Поиск по фамилии: " + lastName);
        List<Employee> employees = employeeRepository.findByLastName(lastName);
        for(Employee employee : employees){
            System.out.println(employee);
        }
        System.out.println("Поиск завершен");
    }

    public void printEmployeeYoungerThan(LocalDate date){
        System.out.println("Поиск младше возраста: " + date);
        List<Employee> employees = employeeRepository.findYoungerThan(date);
        for(Employee employee : employees){
            System.out.println(employee);
        }
        System.out.println("Поиск завершен");
    }

    public void printEmployeeOlderThan(LocalDate date){
        System.out.println("Поиск старше возраста: " + date);
        List<Employee> employees = employeeRepository.findOlderThan(date);
        for(Employee employee : employees){
            System.out.println(employee);
        }
        System.out.println("Поиск завершен");
    }

    public void printEmployeeByPosition(String positionName){
        System.out.println("Поиск по должности: " + positionName);
        List<Employee> employees = employeeRepository.findByPosition(positionName);
        for(Employee emp : employees){
            System.out.println(emp);
        }
        System.out.println("Поиск завершен");
    }

}
