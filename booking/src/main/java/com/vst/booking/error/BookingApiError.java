package com.vst.booking.error;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vst.booking.exception.BookingNotFoundException;
import com.vst.booking.exception.IdNotAcceptableException;

@RestControllerAdvice
public class BookingApiError {
	
	 String message ="error message";

	@ExceptionHandler(BookingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> userNotFound(BookingNotFoundException ex){
        Map<String, Object> errorMap = new HashMap<>();
        BookingErrorResponse response = new BookingErrorResponse();
        response.setMessage("details you have given is not present");
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setStatusCode("404");
        response.setTimeStamp(LocalDateTime.now());
        errorMap.put(message, response);
        return errorMap;
    }
   
	@ExceptionHandler(IdNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Map<String, Object> idNotFound(IdNotAcceptableException ex){
        Map<String, Object> errorMap = new HashMap<>();
        BookingErrorResponse response = new BookingErrorResponse();
        response.setMessage("ID is not correct or not available");
        response.setStatus(HttpStatus.NOT_ACCEPTABLE);
        response.setStatusCode("406");
        response.setTimeStamp(LocalDateTime.now());
        errorMap.put(message, response);
        return errorMap;
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> nullPointer(NullPointerException ex){
        Map<String, Object> errorMap = new HashMap<>();
        BookingErrorResponse response = new BookingErrorResponse();
        response.setMessage("Same Field are empty");
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setStatusCode("406");
        response.setTimeStamp(LocalDateTime.now());
        errorMap.put(message, response);
        return errorMap;
    }
}
