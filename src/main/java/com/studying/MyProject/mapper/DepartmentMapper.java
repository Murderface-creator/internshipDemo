package com.studying.MyProject.mapper;

import com.studying.MyProject.DTO.DepartmentDTO;
import com.studying.MyProject.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentMapper {

    public DepartmentDTO toDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName(department.getName());
        List<String> employeeNames = department.getListOfDepartments().stream()
                .map(ed -> ed.getEmployee().getFirstName() + " " + ed.getEmployee().getLastName())
                .toList();
        departmentDTO.setEmployeeNames(employeeNames);
        return departmentDTO;
    }

    public List<DepartmentDTO> toDTOList(List<Department> departments){
        return departments.stream().map(this::toDTO).toList();
    }
}
