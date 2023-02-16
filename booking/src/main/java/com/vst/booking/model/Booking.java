package com.vst.booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection="booking")
public class Booking {

	@Id
	private String bookingId;
	private String bookingType;
	private String bookingHostId;
	private String bookingCustomerId;
	private String bookingVendorId;
	private String bookingStationId;
	private String bookingDate;
	private String bookingTime;
	private String bookingCancellationReason;
	private String bookingStatus;
	private String bookingReqDate;
	private String bookingCancellationReqDate;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private boolean isActive;


}
