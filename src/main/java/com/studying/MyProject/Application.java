//package com.studying.MyProject;
//
//import com.studying.MyProject.service.DocumentService;
//import com.studying.MyProject.service.EmployeeService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import java.time.LocalDate;
//import java.time.Month;
//
//@SpringBootApplication
//public class Application implements CommandLineRunner {
//
//    private final DocumentService documentService;
//
//    public Application(EmployeeService employeeService, DocumentService documentService) {
//        this.documentService = documentService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        documentService.findEmployeesLastNameWithDocumentsIssueOlderThan(LocalDate.of(2010, Month.JANUARY, 1));
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}
