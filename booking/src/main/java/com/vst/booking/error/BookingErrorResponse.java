package com.vst.booking.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BookingErrorResponse {

	private String message;
    private HttpStatus status;
    private String statusCode;
    private LocalDateTime timeStamp;
	
}
