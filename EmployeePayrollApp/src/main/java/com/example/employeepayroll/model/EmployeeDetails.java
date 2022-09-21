package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDetails {

    String firstName;
    String lastName;
    String gender;
    String department;
    long empSalary;

    public EmployeeDetails(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.department = employeeDTO.getDepartment();
        this.gender = employeeDTO.getGender();
        this.message = employeeDTO.getMessage();
        this.id = id;
        this.empSalary = employeeDTO.getEmpSalary();
    }

    String message;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;


    public EmployeeDetails(String message) {
        this.message = message;
    }

}
