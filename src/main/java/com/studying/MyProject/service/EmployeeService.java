package com.studying.MyProject.service;

import com.studying.MyProject.DTO.EmployeeDTO;
import com.studying.MyProject.entity.Employee;
import com.studying.MyProject.mapper.EmployeeMapper;
import com.studying.MyProject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> getEmployeeByFirstName(String firstName) {
        List<Employee> employees = employeeRepository.findByFirstName(firstName);
        return employeeMapper.toDTOList(employees);
    }

    public List<EmployeeDTO> getEmployeeByLastName(String lastName){
        List<Employee> employees = employeeRepository.findByLastName(lastName);
        employeeMapper.toDTOList(employees);
        return employeeMapper.toDTOList(employees);
    }

    public List<EmployeeDTO> getEmployeeYoungerThan(LocalDate date){
        List<Employee> employees = employeeRepository.getEmployeeYoungerThan(date);
        return employeeMapper.toDTOList(employees);
    }

    public List<EmployeeDTO> getEmployeeOlderThan(LocalDate date){
        List<Employee> employees = employeeRepository.getEmployeeOlderThan(date);
        return employeeMapper.toDTOList(employees);
    }

    public List<EmployeeDTO> getEmployeeByPosition(String positionName){
        List<Employee> employees = employeeRepository.findByPositionName(positionName);
        return employeeMapper.toDTOList(employees);

    }

    public List<EmployeeDTO> findAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDTOList(employees);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }



    public EmployeeDTO getEmployeeById(Long id){
        return employeeMapper.toDTO(employeeRepository.findById(id).get());
    }

}
