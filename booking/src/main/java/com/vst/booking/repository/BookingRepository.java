package com.vst.booking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.vst.booking.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

	Booking findByBookingIdAndIsActiveTrue(String bookingId);
	
	List<Booking> findAllByIsActiveTrue();
	
}
