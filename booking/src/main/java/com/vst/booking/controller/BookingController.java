package com.vst.booking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.booking.dto.BookingDto;
import com.vst.booking.model.Booking;
import com.vst.booking.service.BookingServiceImpl;

@RestController
@RequestMapping("/vst1")
@CrossOrigin(origins = "*")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingServiceImpl;

	@PostMapping("/booking")
	public ResponseEntity<String> addBooking(@Valid @RequestBody BookingDto bookingDto) {

		bookingServiceImpl.add(bookingDto);
		return new ResponseEntity<>("Booking Successfully", HttpStatus.OK);
	}

	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> getAllBooking() {
		return ResponseEntity.ok(bookingServiceImpl.showAll());
	}

	@GetMapping("/booking")
	public ResponseEntity<Booking> getBooking(@RequestParam("bookingId") String bookingId) {
		return ResponseEntity.ok(bookingServiceImpl.show(bookingId));
	}

	@PutMapping("/booking")
	public ResponseEntity<String> updateBooking(@RequestParam("bookingId") String bookingId,
			@RequestBody BookingDto bookingDto) {

		bookingServiceImpl.edit(bookingId, bookingDto);
		return new ResponseEntity<>("Booking Details Updated Succesfully", HttpStatus.OK);
	}

	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable String bookingId) {

		bookingServiceImpl.remove(bookingId);
		return new ResponseEntity<>("Booking Deleted Succesfully", HttpStatus.OK);
	}

	@GetMapping("/bookingsHost")
	public ResponseEntity<List<Booking>> getAllBookingByHost(@RequestParam("bookingHostId") String bookingHostId) {
		return ResponseEntity.ok(bookingServiceImpl.getDetailsByHostId(bookingHostId));
	}

	@GetMapping("/bookingsCustomer")
	public ResponseEntity<Booking> getBookingByCustomerId(@RequestParam("bookingCustomerId") String bookingCustomerId) {
		return ResponseEntity.ok(bookingServiceImpl.getDetailsByCustomerId(bookingCustomerId));
	}

	@GetMapping("/bookingsVendor")
	public ResponseEntity<List<Booking>> getAllBookingByVendorId(
			@RequestParam("bookingVendorId") String bookingVendorId) {
		return ResponseEntity.ok(bookingServiceImpl.getDetailsByVendorId(bookingVendorId));
	}

	@GetMapping("/bookingsStation")
	public ResponseEntity<List<Booking>> getAllBookingByStationID(
			@RequestParam("bookingStationId") String bookingStationId) {
		return ResponseEntity.ok(bookingServiceImpl.getDetailsByStationId(bookingStationId));
	}

	@GetMapping("/bookingsStatus")
	public ResponseEntity<List<Booking>> getAllBookingByStatus(@RequestParam("bookingStatus") String bookingStatus) {
		return ResponseEntity.ok(bookingServiceImpl.getDetailsByStatus(bookingStatus));
	}

	@PostMapping("/bookingadd")
	public void mult() {
		BookingDto booking = new BookingDto();

		for (int i = 1; i < 100; i++) {

			booking.setBookingId("1234" + i);
			booking.setBookingType("reservation" + i);
			booking.setBookingHostId("5678" + i);
			booking.setBookingCustomerId("9012" + i);
			booking.setBookingVendorId("3456" + i);
			booking.setBookingStationId("XYZ123" + i);
			booking.setBookingDate("2023-03-01" + i);
			booking.setBookingTime("15:00:00" + i);
			booking.setBookingCancellationReason("null" + i);
			booking.setBookingStatus("confirmed" + i);
			booking.setBookingReqDate("2023-02-28" + i);
			booking.setBookingCancellationReqDate("null" + i);
			booking.setCreatedDate("2023-02-15" + i);
			booking.setModifiedDate("2023-02-15" + i);
			booking.setCreatedBy("John Doe" + i);
			booking.setModifiedBy("Jane Smith" + i);
			booking.setActive(true);
			bookingServiceImpl.add(booking);
		}

	}
}