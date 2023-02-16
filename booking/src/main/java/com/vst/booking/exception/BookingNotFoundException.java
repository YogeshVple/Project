package com.vst.booking.exception;

public class BookingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7136395761401538992L;

	public BookingNotFoundException(String message) {
		super(message);
	}

}
