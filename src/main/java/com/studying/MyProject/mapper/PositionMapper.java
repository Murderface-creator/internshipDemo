package com.studying.MyProject.mapper;

import com.studying.MyProject.DTO.PositionDTO;
import com.studying.MyProject.entity.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionMapper {

    private final EmployeeMapper employeeMapper;

    public PositionMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public PositionDTO toDTO(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setName(position.getName());
        positionDTO.setEmployees(employeeMapper.toDTOList(position.getEmployees()));
        return positionDTO;
    }

    public List<PositionDTO> toDTOList(List<Position> positions) {
        return positions.stream().map(this::toDTO).toList();
    }
}
