package com.vst.transaction.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class TransactionErrorResponse {
	
	private String message;
    private HttpStatus status;
    private String statusCode;
    private LocalDateTime timeStamp;

}
