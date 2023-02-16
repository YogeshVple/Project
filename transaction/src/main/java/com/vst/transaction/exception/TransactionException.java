package com.vst.transaction.exception;

public class TransactionException extends RuntimeException {
	
	private static final long serialVersionUID = 215232344516490651L;

	public TransactionException(String message) {
		super(message);
	}
}
