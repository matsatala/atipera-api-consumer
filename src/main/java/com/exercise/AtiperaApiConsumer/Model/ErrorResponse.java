package com.exercise.AtiperaApiConsumer.Model;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class ErrorResponse {


    private String status;
    private String message;



    public ErrorResponse(HttpStatusCode status, String message) {
        this.status = "${"+status+"}";
        this.message = "${"+message+"}";
    }

}
