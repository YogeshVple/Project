package com.vst.station.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "station")
public class Station {

	@Id
	private String stationId;
	private String stationName;
	private String stationHostId;
	private String stationVendorId;
	private String stationLocation;
	private String stationLocationURL;
	private String stationParkingArea;
	private String stationContactNumber;
	private String stationWorkingTime;
	private String stationParkingType;
	private ArrayList<String> stationAmenity;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private boolean isActive;

}
