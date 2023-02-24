package com.vst.booking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

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

	@NotBlank
	@NotNull(message = "Please Select Correct Type")
	@Pattern(regexp = "(^[A-Z][a-z]+$)", message = "Please Enter Correct Details")
	private String bookingType;

	@NotBlank
	@NotNull(message = "Invaild Host ID")
	private String bookingHostId;

	@Indexed
	@NotBlank
	@NotNull(message = "Invaild Customer ID")
	private String bookingCustomerId;

	@NotBlank
	@NotNull(message = "Invaild Vendor ID")
	private String bookingVendorId;

	@NotBlank
	@NotNull(message = "Invaild Station ID")
	private String bookingStationId;

	@NotBlank
	@NotNull(message = "Invaild Date Format") // DD/MM/YYYY (correct format acceptable to this pattern with leap year)
	@Pattern(regexp = "^\\b(?:(?:0[1-9]|1\\d|2[0-8]|[1-9])-(?:0?2)-(?:\\d+)"
			+ "|(?:0[1-9]|1\\d|2\\d|[1-9])-(?:0?2)-(?:(?:\\d*?(?:(?:0[48]|[13579][26]|[2468][048])|"
			+ "(?:(?:[02468][048]|[13579][26])00))|[48]00|[48])(?=\\D|\\b))|(?:0[1-9]|1\\d|2\\d|30|"
			+ "[1-9])-(?:0?[469]|11)-(?:\\d+)|(?:0[1-9]|1\\d|2\\d|3[01]|[1-9])-(?:0?[13578]|1[02])-"
			+ "(?:\\d+))\\b$", message = "Please Enter Correct Date")
	private String bookingDate;

	@NotBlank
	@NotNull(message = "Please Select Correct Time Slot") // (Correct Date format : 10:30:00 PM)
	@Pattern(regexp = "^([1-9]|1[0-2]):[0-5][0-9]:[0-5][0-9] (AM|PM)$" , message = "Please Select Correct Time Slot")
	private String bookingTime;

	private String bookingCancellationReason;

	@NotBlank
	@NotNull(message = "Samthing Went Wrong")
	private String bookingStatus;

	@Pattern(regexp = "^\\b(?:(?:0[1-9]|1\\d|2[0-8]|[1-9])-(?:0?2)-(?:\\d+)"
			+ "|(?:0[1-9]|1\\d|2\\d|[1-9])-(?:0?2)-(?:(?:\\d*?(?:(?:0[48]|[13579][26]|[2468][048])|"
			+ "(?:(?:[02468][048]|[13579][26])00))|[48]00|[48])(?=\\D|\\b))|(?:0[1-9]|1\\d|2\\d|30|"
			+ "[1-9])-(?:0?[469]|11)-(?:\\d+)|(?:0[1-9]|1\\d|2\\d|3[01]|[1-9])-(?:0?[13578]|1[02])-"
			+ "(?:\\d+))\\b$", message = "Please Enter Correct Date")
	private String bookingReqDate;

	
	
	
	@Pattern(regexp = "^\\b(?:(?:0[1-9]|1\\d|2[0-8]|[1-9])-(?:0?2)-(?:\\d+)"
			+ "|(?:0[1-9]|1\\d|2\\d|[1-9])-(?:0?2)-(?:(?:\\d*?(?:(?:0[48]|[13579][26]|[2468][048])|"
			+ "(?:(?:[02468][048]|[13579][26])00))|[48]00|[48])(?=\\D|\\b))|(?:0[1-9]|1\\d|2\\d|30|"
			+ "[1-9])-(?:0?[469]|11)-(?:\\d+)|(?:0[1-9]|1\\d|2\\d|3[01]|[1-9])-(?:0?[13578]|1[02])-"
			+ "(?:\\d+))\\b$", message = "Please Enter Correct Date")
	private String bookingCancellationReqDate;
	
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;

	private boolean isActive;
}
