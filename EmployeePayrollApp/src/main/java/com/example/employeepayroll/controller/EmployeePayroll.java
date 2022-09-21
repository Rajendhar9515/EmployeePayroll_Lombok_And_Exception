package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.model.EmployeeDetails;
import com.example.employeepayroll.service.EmployeePayrollService;
import com.example.employeepayroll.service.IEmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayroll {

    @Autowired
    IEmployeeInterface iEmployeeInterface;

//    List<EmployeeDetails> list = new ArrayList<>();

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Data saved successfully", iEmployeeInterface.saveAll(employeeDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/empdata")
    public ResponseEntity<ResponseDTO> displayAll(){
        ResponseDTO responseDTO = new ResponseDTO("Get call successfully", iEmployeeInterface.display());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("Get call for Id successfully", iEmployeeInterface.findById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Updated data successfully", iEmployeeInterface.update(employeeDTO, id));
       return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        Boolean isEmpID = iEmployeeInterface.deleteById(id);
        String message = isEmpID ? "Deleted by Id successfully" : "Id is Not Found";
        ResponseDTO responseDTO = new ResponseDTO(message);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

