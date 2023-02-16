package com.vst.booking.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


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
	
	@NotBlank @NotNull(message = "Please Select Correct Type")
	private String bookingType;
	
	@NotBlank @NotNull (message = "Invaild Host ID")
	private String bookingHostId;
	
	@NotBlank @NotNull (message = "Invaild Customer ID")
	private String bookingCustomerId;
	
	@NotBlank @NotNull (message = "Invaild Vendor ID")
	private String bookingVendorId;
	
	@NotBlank @NotNull(message = "Invaild Station ID")
	private String bookingStationId;
	
	@NotBlank @NotNull (message = "Invaild Date Format")
	private String bookingDate;
	
	@NotBlank @NotNull (message = "Please Select Correct Time Slot")
	private String bookingTime;
	
	@NotBlank @NotNull (message = "Please Enter Vaild")
	private String bookingCancellationReason;
	
	@NotBlank @NotNull (message = "Samthing Went Wrong")
	private String bookingStatus;
	
	@NotBlank @NotNull (message = "Please Select Correct Booking Date")
	private String bookingReqDate;
	
	@NotBlank @NotNull (message = "Please Select Correct Cancellation Date")
	private String bookingCancellationReqDate;
	 
	@NotBlank @NotNull (message = "Please Select Correct Created Date")
	private String createdDate;
	
	@NotBlank @NotNull (message = "Please Select Correct Modified Date")
	private String modifiedDate;
	
	@NotBlank@NotNull (message = "Update Created By")
	private String createdBy;
	
	@NotBlank@NotNull (message = "Update Modified By")
	private String modifiedBy;
	
	private boolean isActive;
}
