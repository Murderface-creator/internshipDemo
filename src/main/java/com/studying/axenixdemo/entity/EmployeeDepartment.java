package com.studying.axenixdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_department")
@Getter
@Setter
public class EmployeeDepartment {
    @EmbeddedId
    private EmployeeDepartmentId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("departmentId")
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @Column(name = "assigned_at")
    private LocalDateTime assignedAt;

    public EmployeeDepartment() {}

    public EmployeeDepartment(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
        this.id = new EmployeeDepartmentId(employee.getId(), department.getId());
        this.assignedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "id=" + id +
                ", department=" + department +
                ", employee=" + employee +
                ", assignedAt=" + assignedAt +
                '}';
    }
}
