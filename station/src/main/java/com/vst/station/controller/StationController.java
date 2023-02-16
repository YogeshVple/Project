package com.vst.station.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.station.dto.StationDto;
import com.vst.station.exception.StationException;
import com.vst.station.model.Station;
import com.vst.station.service.StationServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/station")
public class StationController {

	@Autowired
	StationServiceImpl stationServiceImpl;

	private static final Logger logger = LogManager.getLogger(StationController.class);

	@PostMapping("/stationDetails")
	@Validated
	public ResponseEntity<String> saveStation(@Valid @RequestBody StationDto stationDto) {

		StationDto stationObj = stationServiceImpl.addstation(stationDto);
		if (stationObj != null) {
			return new ResponseEntity<>("Station Added Sucessfully", HttpStatus.OK);
		} else {
			logger.error("Samthing Went Wrong");
			return new ResponseEntity<>("Enterd Details Wrong Please Check", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/stationUpdate")
	public ResponseEntity<String> updateStation(@RequestParam("stationId") String stationId,
			@Valid @RequestBody StationDto stationDto) {

		if (stationId != null) {
			if (stationServiceImpl.updateStationDetails(stationId, stationDto)) {
				return new ResponseEntity<>("Station Details Upated Succesfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Details not found", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>("Station ID not Vaild Please Enter Vaild Id", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("/stationDelete")
	public ResponseEntity<String> deleteStationDetails(@RequestParam("stationId") String stationId) {
		if (stationId != null) {
			if (stationServiceImpl.deleteStation(stationId)) {
				return new ResponseEntity<>("Delete Susccessfully", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>("Station Details Not Found", HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("Provided ID Not Vaild Plese Enter Vaild ID", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/stations")
	public ResponseEntity<List<Station>> getStationDetails() {
		
		List<Station> list = stationServiceImpl.getAllStation();
		if(list.isEmpty()) {
			throw new StationException("no data");
		}else {
			return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		}
		
	
	}
}
