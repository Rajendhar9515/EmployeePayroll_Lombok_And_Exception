package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;

public interface IEmployeeInterface {
    Object saveAll(EmployeeDTO employeeDTO);

    Object display();

    Object findById(int id);

    Object update(EmployeeDTO employeeDTO, int id);

    Boolean deleteById(int id);
}
