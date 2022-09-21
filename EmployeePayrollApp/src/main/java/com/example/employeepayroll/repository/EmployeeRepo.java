package com.example.employeepayroll.repository;

import com.example.employeepayroll.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Integer> {
}
