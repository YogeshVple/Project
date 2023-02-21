package com.vst.station.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.vst.station.model.Station;

@EnableMongoRepositories
public interface StationRepository extends MongoRepository<Station, String> {
	
	Station findByStationIdAndIsActiveTrue(String stationId);
	
	public List<Station>findAllByIsActiveTrue();
	
	List<Station> findByStationHostIdAndIsActiveTrue(String stationHostId);
	
	List<Station> findByStationVendorIdAndIsActiveTrue(String stationVendorId);
	
	List<Station> findByStationLocationAndIsActiveTrue(String stationLocation);
	
	List<Station> findByStationParkingAreaAndIsActiveTrue(String stationParkingArea);
	
	List<Station> findByStationWorkingTimeAndIsActiveTrue(String stationWorkingTime);
	
	List<Station> findByStationParkingTypeAndIsActiveTrue(String stationParkingType);
	
	Station findByStationNameAndIsActiveTrue(String stationName);
	
}
