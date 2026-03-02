package com.studying.MyProject.controller;

import com.studying.MyProject.DTO.EmployeeDTO;
import com.studying.MyProject.exeptionHandling.EmployeeIncorrectData;
import com.studying.MyProject.exeptionHandling.NoSuchEmployeeException;
import com.studying.MyProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/allEmployees")
    public List<EmployeeDTO> showAllEmployees(){
       return employeeService.findAllEmployees();
    }

    @GetMapping("/showEmployee{id}")
    public EmployeeDTO showEmployee(@PathVariable Long id){
        if(employeeService.getEmployeeById(id) == null){
            throw new NoSuchEmployeeException("Employee not found with id: " + id);
        } else {
            return employeeService.getEmployeeById(id);
        }
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> exceptionHandler(NoSuchEmployeeException exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
