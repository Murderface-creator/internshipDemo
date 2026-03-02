package com.studying.MyProject.service;

import com.studying.MyProject.DTO.EmployeeDTO;
import com.studying.MyProject.entity.Employee;
import com.studying.MyProject.entity.Position;
import com.studying.MyProject.exception.ResourceNotFoundException;
import com.studying.MyProject.mapper.EmployeeMapper;
import com.studying.MyProject.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    EmployeeService employeeService;

    private Employee employee1;
    private Employee employee2;
    private EmployeeDTO employeeDTO;
    private EmployeeDTO employeeDTO2;
    private Position position;

    @BeforeEach
    void setUp(){
        employee1 = new Employee();
        employee2 = new Employee();
        position = new Position();
        employee1.setId(1L);
        employee1.setFirstName("John");
        employee1.setLastName("Smith");
        employee1.setBirthDate(LocalDate.of(2000, 11, 28));
        position.setName("Software Engineering");
        employee1.setPosition(position);
        employee2.setId(2L);
        employee2.setFirstName("Jane");
        employee2.setLastName("Jakson");
        employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setFirstName("John");
        employeeDTO.setLastName("Smith");
        employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setId(2L);
        employeeDTO2.setFirstName("Jane");
        employeeDTO2.setLastName("Jakson");
    }

    @Test
    void getEmployeeById_ExistingId_ReturnsDTO(){
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));
        when(employeeMapper.toDTO(employee1)).thenReturn(employeeDTO);
        EmployeeDTO result = employeeService.getEmployeeById(1L);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isEqualTo(1L);
    }

    @Test
    void getEmployeeById_NotFound_ThrowsException(){
        when(employeeRepository.findById(900L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> employeeService.getEmployeeById(900L))
        .isInstanceOf(NoSuchElementException.class)
        .hasMessage("No value present");
    }

    @Test
    void findAllEmployeesTest(){
        List<Employee> employees = List.of(employee1, employee2);
        List<EmployeeDTO> employeeDTOS = List.of(employeeDTO, employeeDTO2);
        when(employeeRepository.findAll()).thenReturn(employees);
        when(employeeMapper.toDTOList(employees)).thenReturn(employeeDTOS);
        List<EmployeeDTO> result = employeeService.findAllEmployees();
        Assertions.assertThat(result).isNotNull().hasSize(2).extracting(EmployeeDTO::getFirstName).containsExactly("John", "Jane");
    }

    @Test
    void getEmployeeByPosition_ReturnsDTO(){
        List<Employee> employees = List.of(employee1);
        when(employeeRepository.findByPositionName(position.getName())).thenReturn(List.of(employee1));
        when(employeeMapper.toDTOList(employees)).thenReturn(List.of(employeeDTO));
        List<EmployeeDTO> result = employeeService.getEmployeeByPosition(position.getName());
        Assertions.assertThat(result).isNotNull().hasSize(1).extracting(EmployeeDTO::getFirstName).containsExactly("John");
    }

    @Test
    void findOlderThan_ReturnsDTO(){
        List<Employee> employees = List.of(employee1);
        List<EmployeeDTO> employeeDTOS = List.of(employeeDTO);
        when(employeeRepository.getEmployeeOlderThan(LocalDate.now())).thenReturn(employees);
        when(employeeMapper.toDTOList(employees)).thenReturn(employeeDTOS);
        List<EmployeeDTO> result = employeeService.getEmployeeOlderThan(LocalDate.now());
        Assertions.assertThat(result).isNotNull().hasSize(1).extracting(EmployeeDTO::getFirstName).containsExactly("John");
    }

    @Test
    void deleteEmployeeById_ExistingId(){
        Long id = 1L;
        employeeService.deleteEmployeeById(id);
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(id);
    }
}
