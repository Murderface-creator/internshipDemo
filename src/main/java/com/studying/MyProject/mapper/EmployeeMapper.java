package com.studying.MyProject.mapper;

import com.studying.MyProject.DTO.EmployeeDTO;
import com.studying.MyProject.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    private final DocumentMapper documentMapper;

    public EmployeeMapper(DocumentMapper documentMapper) {
        this.documentMapper = documentMapper;
    }

    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setBirthDate(employee.getBirthDate());
        employeeDTO.setEmail(employee.getEmail());
        if(employee.getDepartments()!=null) {
            List<String> departmentNames = employee.getDepartments().stream()
                    .map(ed -> ed.getDepartment().getName())
                    .toList();
            employeeDTO.setDepartmentName(departmentNames);
        }
        employeeDTO.setPositionName(employee.getPosition().getName());
        employeeDTO.setDocuments(documentMapper.toDTOList(employee.getDocuments()));
        return employeeDTO;
    }

    public List<EmployeeDTO> toDTOList(List<Employee> employees){
        return employees.stream().map(this::toDTO).toList();
    }

}
