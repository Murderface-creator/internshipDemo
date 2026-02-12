package com.studying.MyProject.service;

import com.studying.MyProject.entity.Employee;
import com.studying.MyProject.repository.EmployeeRepository;
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

    public List<Employee> getEmployeeByFirstName(String firstName) {
        System.out.println("Поиск по имени: " + firstName);
        List<Employee> employees = employeeRepository.findByFirstName(firstName);
        return employees;
    }

    public List<Employee> getEmployeeByLastName(String lastName){
        System.out.println("Поиск по фамилии: " + lastName);
        List<Employee> employees = employeeRepository.findByLastName(lastName);
        return employees;
    }

    public List<Employee> getEmployeeYoungerThan(LocalDate date){
        System.out.println("Поиск младше возраста: " + date);
        List<Employee> employees = employeeRepository.findYoungerThan(date);
        return employees;
    }

    public List<Employee> getEmployeeOlderThan(LocalDate date){
        System.out.println("Поиск старше возраста: " + date);
        List<Employee> employees = employeeRepository.findOlderThan(date);
        return employees;
    }

    public List<Employee> getEmployeeByPosition(String positionName){
        System.out.println("Поиск по должности: " + positionName);
        List<Employee> employees = employeeRepository.findByPosition(positionName);
        return employees;

    }

    public List<Employee> getAllEmployees(){
        System.out.println("Поиск всех сотрудников");
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee saveEmployee(Employee employee){
        System.out.println("Сохранение работника");
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee){
        System.out.println("Удаляем работника");
        employeeRepository.delete(employee);
    }

    public Employee getEmployeeById(int id){
        System.out.println("Поиск работника по ID: " + id);
        return employeeRepository.findById(id).get();
    }


}
