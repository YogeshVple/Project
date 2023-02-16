package com.vst.booking.conveter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.booking.dto.BookingDto;
import com.vst.booking.model.Booking;


@Component
public class BookingConveter {
	
	public Booking dtoToEntity(BookingDto station) {
		Booking object = new Booking();
		BeanUtils.copyProperties(station, object);
		return object;
	}
	
	public BookingDto entityToDto(Booking booking) {

		BookingDto object = new BookingDto();
		BeanUtils.copyProperties(booking, object);
		return object;
	}

}

