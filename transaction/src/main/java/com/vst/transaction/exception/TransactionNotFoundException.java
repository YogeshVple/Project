package com.vst.transaction.exception;

public class TransactionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1662335113993987782L;

	public TransactionNotFoundException(String message) {
		super(message);
		
	}

}
