package com.example.ecommerce.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    // for handling the validation exeception :
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException e){
        
        Map<String,String> response = new  HashMap<>();
        e.getBindingResult().getAllErrors().forEach(
            err -> {
                String fieldName = ((FieldError)err).getField(); // fieldName = "message".
                String message = err.getDefaultMessage();
                response.put(fieldName, message);
            }
        );
        return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
    }

    // for handling the not found resources :
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    // for handling the api exception : like the when category name already exist or email already exist stuff like these
    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> apiExceptionHandler(APIException e){
        String message = e.getMessage();
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
    
}
