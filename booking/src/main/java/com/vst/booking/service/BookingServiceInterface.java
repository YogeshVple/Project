package com.vst.booking.service;

import java.util.List;

import com.vst.booking.dto.BookingDto;
import com.vst.booking.model.Booking;

public interface BookingServiceInterface {

	public String add(BookingDto bookingDto);
	
	public void edit(String bookingId, BookingDto bookingDto);
	
	public void remove(String bookingId);
	
	public List<Booking> showAll();

	public Booking show(String bookingId);
}
