package com.studying.MyProject.repository;

import com.studying.MyProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByLastName(String lastName);
    List<Employee> findByFirstName(String firstName);

    @Query("SELECT e FROM Employee e WHERE e.birthDate > :date")
    List<Employee> findYoungerThan(@Param("date")LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.birthDate < :date")
    List<Employee> findOlderThan(@Param("date")LocalDate date);

    @Query("SELECT e FROM Employee e JOIN e.position p WHERE p.name = :positionName")
    List<Employee> findByPosition(@Param("positionName")String positionName);

}
