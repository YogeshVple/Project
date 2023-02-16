package com.vst.station.service;


import java.util.List;

import com.vst.station.dto.StationDto;
import com.vst.station.model.Station;

public interface StationServiceInterface {

	public StationDto addstation(StationDto stationDto);
	
	public boolean updateStationDetails(String stationId, StationDto stationDto);
	
	public boolean deleteStation(String stationId);
	
	public List<Station> getAllStation();
	
	
}
