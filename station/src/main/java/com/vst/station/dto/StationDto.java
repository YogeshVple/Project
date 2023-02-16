package com.vst.station.dto;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
public class StationDto {
	
	@Transient
	public static final String SEQUENCE_NAME = "station_sequence";
	
	@Id
	private String stationId;
	@NotNull
	private String stationName;
	@NotNull
	private String stationHostId;
	@NotNull
	private String stationVendorId;
	@NotNull
	private String stationLocation;
	@NotNull
	private String stationLocationURL;
	@NotNull
	private String stationParkingArea;
	@NotNull
	private String stationContactNumber;
	@NotNull
	private String stationWorkingTime;
	@NotNull
	private String stationParkingType;
	private ArrayList<String> stationAmenity;
	@NotNull
	private String createdDate;
	@NotNull
	private String modifiedDate;
	@NotNull
	private String createdBy;
	@NotNull
	private String modifiedBy;
	private boolean isActive;
	

}
