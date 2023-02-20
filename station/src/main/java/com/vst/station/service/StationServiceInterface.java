package com.vst.station.service;


import java.util.List;

import com.vst.station.dto.StationDto;
import com.vst.station.model.Station;

public interface StationServiceInterface {

	public String add(StationDto stationDto);
	
	public void edit(String stationId, StationDto stationDto);
	
	public void remove(String stationId);
	
	public List<Station> showAll();
	
	
}
