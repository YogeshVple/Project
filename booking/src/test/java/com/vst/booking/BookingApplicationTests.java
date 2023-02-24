package com.vst.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vst.booking.conveter.BookingConveter;
import com.vst.booking.dto.BookingDto;
import com.vst.booking.model.Booking;
import com.vst.booking.repository.BookingRepository;
import com.vst.booking.service.BookingServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookingApplicationTests {

	@Autowired
	BookingConveter bookingConveter;

	@MockBean
	BookingRepository bookingRepository;

	@Autowired
	BookingServiceImpl bookingServiceImpl;

	@Test
	public void saveUserTest() {

		Booking booking = new Booking();
		booking.setBookingId("1234");
		booking.setBookingType("reservation");
		booking.setBookingHostId("5678");
		booking.setBookingCustomerId("9012");
		booking.setBookingVendorId("3456");
		booking.setBookingStationId("XYZ123");
		booking.setBookingDate("2023-03-01");
		booking.setBookingTime("15:00:00");
		booking.setBookingCancellationReason(null);
		booking.setBookingStatus("confirmed");
		booking.setBookingReqDate("2023-02-28");
		booking.setBookingCancellationReqDate(null);
		booking.setCreatedDate("2023-02-15");
		booking.setModifiedDate("2023-02-15");
		booking.setCreatedBy("John Doe");
		booking.setModifiedBy("Jane Smith");
		booking.setActive(true);

		BookingDto dto = bookingConveter.entityToDto(booking);
		when(bookingRepository.save(booking)).thenReturn(booking);
		assertEquals("Data added", bookingServiceImpl.add(dto));
	}
	
	

	
	
}
