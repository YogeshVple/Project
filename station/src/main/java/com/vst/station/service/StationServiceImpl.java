package com.vst.station.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vst.station.converter.StationConveter;
import com.vst.station.dto.StationDto;
import com.vst.station.exception.StationException;
import com.vst.station.model.Station;
import com.vst.station.repository.StationRepository;

import jakarta.transaction.Transactional;

@Service
public class StationServiceImpl implements StationServiceInterface {

	@Autowired
	private StationRepository stationRepository;

	@Autowired
	private StationConveter stationConveter;

	@Autowired
	StationSequenceGeneratorService generatorService;

	@Override
	public StationDto addstation(StationDto stationDto) {

		stationDto.setStationId(generatorService.idGen());
		stationDto.setActive(true);

		Station station = stationConveter.dtoToEntity(stationDto);

		stationRepository.save(station);
		return stationConveter.entityToDto(station);

	}

	@Override
	public boolean updateStationDetails(String stationId, StationDto stationDto) {

		Station stationObj = stationConveter.dtoToEntity(stationDto);

		Station obj = stationRepository.findByStationIdAndIsActiveTrue(stationId);
		if (obj == null) {
			throw new StationException("Not found");
		} else {

			if (stationObj.getStationName() != null)
				obj.setStationName(stationObj.getStationName());
			if (stationObj.getStationHostId() != null)
				obj.setStationHostId(stationObj.getStationHostId());
			if (stationObj.getStationVendorId() != null)
				obj.setStationVendorId(stationObj.getStationVendorId());
			if (stationObj.getStationLocation() != null)
				obj.setStationLocation(stationObj.getStationLocation());
			if (stationObj.getStationLocationURL() != null)
				obj.setStationLocationURL(stationObj.getStationLocationURL());
			if (stationObj.getStationParkingArea() != null)
				obj.setStationParkingArea(stationObj.getStationParkingArea());
			if (stationObj.getStationParkingType() != null)
				obj.setStationParkingType(stationObj.getStationParkingType());
			if (stationObj.getStationContactNumber() != null)
				obj.setStationContactNumber(stationObj.getStationContactNumber());
			if (stationObj.getStationWorkingTime() != null)
				obj.setStationWorkingTime(stationObj.getStationWorkingTime());
			if (stationObj.getCreatedDate() != null)
				obj.setCreatedDate(stationObj.getCreatedDate());
			if (stationObj.getModifiedDate() != null)
				obj.setModifiedDate(stationObj.getModifiedDate());
			if (stationObj.getCreatedBy() != null)
				obj.setCreatedBy(stationObj.getCreatedBy());
			if (stationObj.getModifiedBy() != null)
				obj.setModifiedBy(stationObj.getModifiedBy());
			stationRepository.save(obj);
			return true;
		}
	}

	@Override
	@Transactional
	public boolean deleteStation(String stationId) {
		Station obj = stationRepository.findByStationIdAndIsActiveTrue(stationId);
		if (obj != null) {
			obj.setActive(false);
			stationRepository.save(obj);
			return true;
		} else
			return false;
	}

	@Override
	public List<Station> getAllStation() {
		return stationRepository.findAllByIsActiveTrue();
	}

}
