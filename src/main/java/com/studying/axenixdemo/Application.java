package com.studying.axenixdemo;

import com.studying.axenixdemo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class Application implements CommandLineRunner {

    private final EmployeeService service;

    public Application(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Employee Controller");
        service.printEmployeeByFirstName("Петр");
        service.printEmployeeByLastName("Козлова");
        service.printEmployeeByPosition("Инженер-разработчик");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
