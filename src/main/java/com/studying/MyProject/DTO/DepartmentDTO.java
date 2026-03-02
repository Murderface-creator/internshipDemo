package com.studying.MyProject.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {
    private String departmentName;
    private List<String> employeeNames;

}
