package com.studying.MyProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class EmployeeDepartmentId implements Serializable {
    private Long employeeId;
    private Long departmentId;

    public EmployeeDepartmentId() {
    }

    public EmployeeDepartmentId(Long employeeId, Long departmentId) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) {return true;}
        if(!(o instanceof EmployeeDepartmentId)) {return false;}
        EmployeeDepartmentId that = (EmployeeDepartmentId) o;
        return employeeId==that.employeeId && departmentId==that.departmentId;
    }
    @Override
    public int hashCode(){
        return Objects.hash(employeeId, departmentId);
    }

    @Override
    public String toString() {
        return "EmployeeDepartmentId{" +
                "employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                '}';
    }
}
