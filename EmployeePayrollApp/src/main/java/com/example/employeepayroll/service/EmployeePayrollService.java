package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.exceptionHandling.EmployeeException;
import com.example.employeepayroll.model.EmployeeDetails;
import com.example.employeepayroll.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeeInterface {

    @Autowired
    EmployeeRepo employeeRepo;



    public List<EmployeeDetails> display() {
        return employeeRepo.findAll();
    }

    public EmployeeDetails saveAll(EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetails = new EmployeeDetails(employeeDTO);
        return employeeRepo.save(employeeDetails);
    }
    public EmployeeDetails findById(int id) {
        return employeeRepo.findById(id).orElseThrow(() ->
                new EmployeeException("Employee with id " +id+ " does not exist in database"));
    }

    public EmployeeDetails update(EmployeeDTO employeeDTO, int id){
        if(employeeRepo.findById(id).isPresent()) {
            EmployeeDetails empData = employeeRepo.findById(id).get();
            empData.setFirstName(employeeDTO.getFirstName());
            empData.setLastName(employeeDTO.getLastName());
            empData.setDepartment(employeeDTO.getDepartment());
            empData.setGender(employeeDTO.getGender());
            empData.setEmpSalary(employeeDTO.getEmpSalary());
            empData.setMessage(employeeDTO.getMessage());
            return employeeRepo.save(empData);
        } else {
            return new EmployeeDetails("user id not found");
        }
    }
    public Boolean deleteById(int id) {
        Optional<EmployeeDetails> userId = employeeRepo.findById(id);
        if(userId.isPresent()) {
            employeeRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
