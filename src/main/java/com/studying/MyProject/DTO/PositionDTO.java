package com.studying.MyProject.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PositionDTO {
    private String name;
    private List<EmployeeDTO> employees;
}
