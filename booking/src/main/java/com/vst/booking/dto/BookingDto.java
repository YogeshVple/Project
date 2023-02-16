package com.vst.booking.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDto {

	@Transient
	public static final String SEQUENCE_NAME = "booking_sequence";
	
	@Id
	private String bookingId;
	
	@NotNull(message = "Please Select Correct Type")
	private String bookingType;
	
	@NotNull (message = "Invaild Host ID")
	private String bookingHostId;
	
	@NotNull (message = "Invaild Customer ID")
	private String bookingCustomerId;
	
	@NotNull (message = "Invaild Vendor ID")
	private String bookingVendorId;
	
	@NotNull (message = "Invaild Station ID")
	private String bookingStationId;
	
	@NotNull (message = "Invaild Date Format")
	private String bookingDate;
	
	@NotNull (message = "Please Select Correct Time Slot")
	private String bookingTime;
	
	@NotNull (message = "Please Enter Vaild")
	private String bookingCancellationReason;
	
	@NotNull (message = "Samthing Went Wrong")
	private String bookingStatus;
	
	@NotNull (message = "Please Select Correct Booking Date")
	private String bookingReqDate;
	
	@NotNull (message = "Please Select Correct Cancellation Date")
	private String bookingCancellationReqDate;
	 
	@NotNull (message = "Please Select Correct Created Date")
	private String createdDate;
	
	@NotNull (message = "Please Select Correct Modified Date")
	private String modifiedDate;
	
	@NotNull (message = "Update Created By")
	private String createdBy;
	
	@NotNull (message = "Update Modified By")
	private String modifiedBy;
	
	private boolean isActive;
}
