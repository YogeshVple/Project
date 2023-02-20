package com.vst.station.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.station.dto.StationDto;
import com.vst.station.model.Station;
import com.vst.station.service.StationServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vst1")
@CrossOrigin(origins = "*")
public class StationController {

	@Autowired
	StationServiceImpl stationServiceImpl;
	
	@PostMapping("/station")
	@Validated
	public ResponseEntity<String> saveStation(@Valid @RequestBody StationDto stationDto) {
			stationServiceImpl.add(stationDto);
			return new ResponseEntity<>("Station Added", HttpStatus.OK);
	}

	@PutMapping("/station")
	public ResponseEntity<String> updateStation(@RequestParam("stationId") String stationId,
			@Valid @RequestBody StationDto stationDto) {
		stationServiceImpl.edit(stationId, stationDto);
		return new ResponseEntity<>("Station Details Updated Succesfully", HttpStatus.OK);

	}

	@DeleteMapping("/station")
	public ResponseEntity<String> deleteStation(@RequestParam("stationId") String stationId) {
		stationServiceImpl.remove(stationId);
		return new ResponseEntity<>("Booking Deleted Succesfully", HttpStatus.OK);
	}

	@GetMapping("/stations")
	public ResponseEntity<List<Station>> getAllStation() {
		return ResponseEntity.ok(stationServiceImpl.showAll());

	}
}
