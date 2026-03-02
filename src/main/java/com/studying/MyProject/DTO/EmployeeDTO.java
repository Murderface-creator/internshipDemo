package com.studying.MyProject.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private List<String> departmentName;
    private String positionName;
    private List<DocumentDTO> documents;
}
