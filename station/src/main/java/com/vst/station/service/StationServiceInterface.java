package com.vst.station.service;


import java.util.List;

import com.vst.station.dto.StationDto;
import com.vst.station.model.Station;

public interface StationServiceInterface {

	public String add(StationDto stationDto);
	
	public void edit(String stationId, StationDto stationDto);
	
	public void remove(String stationId);
	
	public List<Station> showAll();
	
	public Station show(String stationId);
	
	public Station getByStationName(String stationName);
	
	public List<Station> getByHostId(String stationHostId);
	
	public List<Station> getByVendorId(String stationVendorId);
	
	public List<Station> getByLocation(String stationLocation);
	
	public List<Station> getByParkingArea(String stationParkingArea);
	
	public List<Station> getByWorkingTime(String stationWorkingTime);
	
	public List<Station> getByParkingType(String stationParkingType);
	
	
}
