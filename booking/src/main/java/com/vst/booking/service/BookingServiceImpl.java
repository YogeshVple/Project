package com.vst.booking.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.booking.conveter.BookingConveter;
import com.vst.booking.dto.BookingDto;
import com.vst.booking.exception.BookingNotFoundException;
import com.vst.booking.exception.IdNotAcceptableException;
import com.vst.booking.model.Booking;
import com.vst.booking.repository.BookingRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

	@Autowired
	BookingConveter bookingConveter;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	BookingSequenceGeneratorService bookingSeqGenService;
	
	private String string = "Please Enter Vaild ID";

	@Override
	public void add(BookingDto bookingDto) {

		bookingDto.setBookingId(bookingSeqGenService.idGen());
		bookingDto.setActive(true);
		Booking booking = bookingConveter.dtoToEntity(bookingDto);
		bookingRepository.save(booking);
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

		if (!bookingId.trim().isEmpty()) {
			Booking obj = bookingRepository.findByBookingIdAndIsActiveTrue(bookingId);
			if (obj != null) {
				return obj;
			} else {
				throw new BookingNotFoundException("No Booking available");
			}
		} else {
			throw new IdNotAcceptableException(string);
		}
	}

	@Override
	public void edit(String bookingId, @Valid BookingDto bookingDto) {

		if (!bookingId.trim().isEmpty()) {
			Booking obj = bookingRepository.findByBookingIdAndIsActiveTrue(bookingId);
			Booking booking = bookingConveter.dtoToEntity(bookingDto);
			if (obj != null) {

				if (!booking.getBookingType().trim().isEmpty())
					obj.setBookingType(booking.getBookingType());

				if (!booking.getBookingHostId().trim().isEmpty())
					obj.setBookingHostId(booking.getBookingHostId());

				if (!booking.getBookingCustomerId().trim().isEmpty())
					obj.setBookingCustomerId(booking.getBookingCustomerId());

				if (!booking.getBookingVendorId().trim().isEmpty())
					obj.setBookingVendorId(booking.getBookingVendorId());

				if (!booking.getBookingStationId().trim().isEmpty())
					obj.setBookingStationId(booking.getBookingStationId());

				if (!booking.getBookingDate().trim().isEmpty())
					obj.setBookingDate(booking.getBookingDate());

				if (!booking.getBookingTime().trim().isEmpty())
					obj.setBookingTime(booking.getBookingTime());

				if (!bookingDto.getBookingCancellationReason().trim().isEmpty())
					obj.setBookingCancellationReason(booking.getBookingCancellationReason());

				if (!booking.getBookingStatus().trim().isEmpty())
					obj.setBookingStatus(booking.getBookingStatus());

				if (!booking.getBookingReqDate().trim().isEmpty())
					obj.setBookingReqDate(booking.getBookingReqDate());

				if (!booking.getBookingCancellationReqDate().trim().isEmpty())
					obj.setBookingCancellationReqDate(booking.getBookingCancellationReqDate());

				if (!booking.getCreatedDate().trim().isEmpty())
					obj.setCreatedDate(booking.getCreatedDate());

				if (!booking.getModifiedDate().trim().isEmpty())
					obj.setModifiedDate(booking.getModifiedDate());

				if (!booking.getCreatedBy().trim().isEmpty())
					obj.setCreatedBy(booking.getCreatedBy());

				if (!booking.getModifiedBy().trim().isEmpty())
					obj.setModifiedBy(booking.getModifiedBy());

				bookingRepository.save(obj);
			} else {
				throw new BookingNotFoundException("No Booking Details available");
			}
		} else {
			throw new IdNotAcceptableException(string);
		}
	}

	@Override
	@Transactional
	public void remove(String bookingId) {

		if (!bookingId.trim().isEmpty()) {
			Booking obj = bookingRepository.findByBookingIdAndIsActiveTrue(bookingId);
			if (obj != null) {
				obj.setActive(false);
				bookingRepository.save(obj);
			} else {
				throw new BookingNotFoundException("Not Found");
			}
		} else {
			throw new IdNotAcceptableException(string);
		}
	}
}
