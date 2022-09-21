package com.example.employeepayroll.dto;

import lombok.Data;

@Data

public class ResponseDTO {

    String message;
    Object data;


    public ResponseDTO(String message, Object data){
        this.message = message;
        this.data =data;

    }
    public  ResponseDTO(String message){
        this.message = message;
    }

}
