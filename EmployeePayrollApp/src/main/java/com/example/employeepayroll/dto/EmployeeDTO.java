package com.example.employeepayroll.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee firstName Invalid")
    String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee lastName Invalid")
    String lastName;

    @NotBlank(message = "Please enter gender")
    String gender;

    @Min(value = 15000, message = "Enter the salary more than 15000")
    long empSalary;


    String department;
    String message;

}
