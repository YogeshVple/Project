package com.vst.booking.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.booking.conveter.BookingConveter;
import com.vst.booking.dto.BookingDto;
import com.vst.booking.exception.BookingNotFoundException;
import com.vst.booking.exception.BookingIdNotAcceptableException;
import com.vst.booking.model.Booking;
import com.vst.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

	@Autowired
	BookingConveter bookingConveter;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	BookingSequenceGeneratorService bookingSeqGenService;

	Date dNow = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH.mm.ss");

	private String string = "Please Enter Vaild ID";

	@Override
	public String add(BookingDto bookingDto) {

		bookingDto.setBookingId(bookingSeqGenService.idGen());
		bookingDto.setActive(true);
		bookingDto.setCreatedDate(dateFormat.format(dNow));
		bookingDto.setModifiedDate(dateFormat.format(dNow));
		Booking booking = bookingConveter.dtoToEntity(bookingDto);
		bookingRepository.save(booking);
		return "Data added";
	}

	@Override
	public List<Booking> showAll() {
		List<Booking> list = bookingRepository.findAllByIsActiveTrue();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new BookingNotFoundException("Data not found");
		}
	}

	@Override
	public Booking show(String bookingId) {

		if (!bookingId.isBlank()) {
			Booking obj = bookingRepository.findByBookingIdAndIsActiveTrue(bookingId);
			if (obj != null) {
				return obj;
			} else {
				throw new BookingNotFoundException("No Booking available");
			}
		} else {
			throw new BookingIdNotAcceptableException(string);
		}
	}

	@Override
	public void edit(String bookingId, BookingDto bookingDto) {

		if (!bookingId.isBlank()) {

			Booking obj = bookingRepository.findByBookingIdAndIsActiveTrue(bookingId);

			Booking booking = bookingConveter.dtoToEntity(bookingDto);
			if (obj != null) {
				
				if (booking.getBookingType() != null && !booking.getBookingType().isBlank())
					obj.setBookingType(booking.getBookingType());

				if (booking.getBookingHostId() != null && !booking.getBookingHostId().isBlank())
						obj.setBookingHostId(booking.getBookingHostId());

				if (booking.getBookingCustomerId() != null && !booking.getBookingCustomerId().isBlank())
						obj.setBookingCustomerId(booking.getBookingCustomerId());

				if (booking.getBookingCustomerId() != null && !booking.getBookingVendorId().isBlank())
						obj.setBookingVendorId(booking.getBookingVendorId());

				if (booking.getBookingStationId() != null && !booking.getBookingStationId().isBlank())
						obj.setBookingStationId(booking.getBookingStationId());

				if (booking.getBookingDate() != null && !booking.getBookingDate().isBlank())
						obj.setBookingDate(booking.getBookingDate());

				if (booking.getBookingTime() != null && !booking.getBookingTime().isBlank())
						obj.setBookingTime(booking.getBookingTime());

				if (booking.getBookingCancellationReason() != null && !bookingDto.getBookingCancellationReason().isBlank())
						obj.setBookingCancellationReason(booking.getBookingCancellationReason());

				if (booking.getBookingStatus() != null && !booking.getBookingStatus().isBlank())
						obj.setBookingStatus(booking.getBookingStatus());

				if (booking.getBookingReqDate() != null && !booking.getBookingReqDate().isBlank())
						obj.setBookingReqDate(booking.getBookingReqDate());

				if (booking.getBookingCancellationReqDate() != null && !booking.getBookingCancellationReqDate().isBlank())
						obj.setBookingCancellationReqDate(booking.getBookingCancellationReqDate());

				if (booking.getCreatedDate() != null && !booking.getCreatedDate().isBlank())
						obj.setCreatedDate(booking.getCreatedDate());

				if (booking.getCreatedBy() != null && !booking.getCreatedBy().isBlank())
						obj.setCreatedBy(booking.getCreatedBy());

				obj.setModifiedDate(dateFormat.format(dNow));
				
				bookingRepository.save(obj);

			} else {
				throw new BookingNotFoundException("No Booking Details available");
			}
		} else {
			throw new BookingIdNotAcceptableException(string);
		}
	}

	@Override
	@Transactional
	public void remove(String bookingId) {

		if (!bookingId.isBlank()) {
			Booking obj = bookingRepository.findByBookingIdAndIsActiveTrue(bookingId);
			if (obj != null) {
				obj.setActive(false);
				bookingRepository.save(obj);
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else {
			throw new BookingIdNotAcceptableException(string);
		}
	}

	@Override
	public List<Booking> getDetailsByHostId(String bookingHostId) {
		if (!bookingHostId.trim().isEmpty()) {
			List<Booking> list = bookingRepository.findAllByBookingHostIdAndIsActiveTrue(bookingHostId);
			if (!list.isEmpty()) {
				return list;
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else
			throw new BookingIdNotAcceptableException(string);
	}

	@Override
	public Booking getDetailsByCustomerId(String bookingCustomerId) {
		if (!bookingCustomerId.trim().isEmpty()) {
			Booking obj = bookingRepository.findByBookingCustomerIdAndIsActiveTrue(bookingCustomerId);
			if (obj != null) {
				return obj;
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else
			throw new BookingIdNotAcceptableException(string);
	}

	@Override
	public List<Booking> getDetailsByVendorId(String bookingVendorId) {
		if (!bookingVendorId.trim().isEmpty()) {
			List<Booking> list = bookingRepository.findAllByBookingVendorIdAndIsActiveTrue(bookingVendorId);
			if (!list.isEmpty()) {
				return list;
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else
			throw new BookingIdNotAcceptableException(string);
	}

	@Override
	public List<Booking> getDetailsByStationId(String bookingStationId) {
		if (!bookingStationId.trim().isEmpty()) {
			List<Booking> list = bookingRepository.findAllByBookingStationIdAndIsActiveTrue(bookingStationId);
			if (!list.isEmpty()) {
				return list;
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else
			throw new BookingIdNotAcceptableException(string);
	}

	@Override
	public List<Booking> getDetailsByStatus(String bookingStatus) {
		if (!bookingStatus.trim().isEmpty()) {
			List<Booking> list = bookingRepository.findAllByBookingStatusAndIsActiveTrue(bookingStatus);
			if (!list.isEmpty()) {
				return list;
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else
			throw new BookingIdNotAcceptableException(string);
	}
}
