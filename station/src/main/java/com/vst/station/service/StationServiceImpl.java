package com.vst.station.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vst.station.converter.StationConveter;
import com.vst.station.dto.StationDto;
import com.vst.station.exception.StationIdNotAcceptableException;
import com.vst.station.exception.StationNotFoundException;
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
	public String add(StationDto stationDto) {

		stationDto.setStationId(generatorService.idGen());
		stationDto.setActive(true);
		Station station = stationConveter.dtoToEntity(stationDto);
		stationRepository.save(station);
		return "Data added";

	}

	@Override
	public void edit(String stationId, StationDto stationDto) {

		if (!stationId.isBlank()) {

			Station stationObj = stationConveter.dtoToEntity(stationDto);

			Station obj = stationRepository.findByStationIdAndIsActiveTrue(stationId);
			if (obj != null) {

				if (stationObj.getStationName() != null)
					if (!stationObj.getStationName().isBlank())
						obj.setStationName(stationObj.getStationName());

				if (stationObj.getStationHostId() != null)
					if (!stationObj.getStationHostId().isBlank())
						obj.setStationHostId(stationObj.getStationHostId());

				if (stationObj.getStationVendorId() != null)
					if (!stationObj.getStationVendorId().isBlank())
						obj.setStationVendorId(stationObj.getStationVendorId());

				if (stationObj.getStationLocation() != null)
					if (!stationObj.getStationLocation().isBlank())
						obj.setStationLocation(stationObj.getStationLocation());

				if (stationObj.getStationLocationURL() != null)
					if (!stationObj.getStationLocationURL().isBlank())
						obj.setStationLocationURL(stationObj.getStationLocationURL());

				if (stationObj.getStationParkingArea() != null)
					if (!stationObj.getStationParkingArea().isBlank())
						obj.setStationParkingArea(stationObj.getStationParkingArea());

				if (stationObj.getStationParkingType() != null)
					if (!stationObj.getStationParkingType().isBlank())
						obj.setStationParkingType(stationObj.getStationParkingType());

				if (stationObj.getStationContactNumber() != null)
					if (!stationObj.getStationContactNumber().isBlank())
						obj.setStationContactNumber(stationObj.getStationContactNumber());

				if (stationObj.getStationWorkingTime() != null)
					if (!stationObj.getStationWorkingTime().isBlank())
						obj.setStationWorkingTime(stationObj.getStationWorkingTime());

				if (stationObj.getCreatedDate() != null)
					if (!stationObj.getCreatedDate().isBlank())
						obj.setCreatedDate(stationObj.getCreatedDate());

				if (stationObj.getModifiedDate() != null)
					if (!stationObj.getModifiedDate().isBlank())
						obj.setModifiedDate(stationObj.getModifiedDate());

				if (stationObj.getCreatedBy() != null)
					if (!stationObj.getCreatedBy().isBlank())
						obj.setCreatedBy(stationObj.getCreatedBy());

				if (stationObj.getModifiedBy() != null)
					obj.setModifiedBy(stationObj.getModifiedBy());
				stationRepository.save(obj);
			} else {
				throw new StationNotFoundException("No Data found");
			}
		} else {
			throw new StationIdNotAcceptableException("Id not Valid");

		}
	}

	@Override
	@Transactional
	public void remove(String stationId) {
		if (!stationId.trim().isEmpty()) {
			Station obj = stationRepository.findByStationIdAndIsActiveTrue(stationId);
			if (obj != null) {
				obj.setActive(false);
				stationRepository.save(obj);
			} else {
				throw new StationNotFoundException("No Data found");
			}
		} else {
			throw new StationIdNotAcceptableException("Id not Valid");
		}
	}

	@Override
	public List<Station> showAll() {
		List<Station> list = stationRepository.findAllByIsActiveTrue();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new StationNotFoundException("No Data found");
		}
	}

}
