package com.vst.station.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.station.dto.StationDto;
import com.vst.station.model.Station;

@Component
public class StationConveter {
	
	public Station dtoToEntity(StationDto station) {
		Station object = new Station();
		BeanUtils.copyProperties(station, object);
		return object;
	}
	
	public StationDto entityToDto(Station station) {

		StationDto object = new StationDto();
		BeanUtils.copyProperties(station, object);
		return object;
	}

}
