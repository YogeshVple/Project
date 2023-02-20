package com.vst.notification.controller;

import java.util.List;

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

import com.vst.notification.dto.NotificationDto;
import com.vst.notification.model.Notification;
import com.vst.notification.service.NotificationServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vst1")
public class NotificationController {

	@Autowired
	NotificationServiceImpl notificationServiceImpl;

	@PostMapping("/notificatoin")
	@Validated
	public ResponseEntity<String> saveNotification(@Valid @RequestBody NotificationDto notificationDto) {
		notificationServiceImpl.add(notificationDto);
			return new ResponseEntity<>("Details Added Sucessfully", HttpStatus.OK);	
	}

	@PutMapping("/notification")
	public ResponseEntity<String> updateNotification(@RequestParam("notificationId") String notificationId,
			@RequestBody NotificationDto notificationDto) {
		notificationServiceImpl.edit(notificationId, notificationDto);
		return new ResponseEntity<>("Notification Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/notification")
	public ResponseEntity<String> deleteNotification(@RequestParam("notificationId") String notificationId){
		notificationServiceImpl.remove(notificationId);
		return new ResponseEntity<>("Notification Delete",HttpStatus.OK);
	}
	
	@GetMapping("/notifications")
	public ResponseEntity<List<Notification>> getAll(){
		return ResponseEntity.ok(notificationServiceImpl.showAll());
	}
}
