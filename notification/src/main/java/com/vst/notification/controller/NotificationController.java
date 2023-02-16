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
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	NotificationServiceImpl notificationServiceImpl;


	@PostMapping("/addNotification")
	@Validated
	public ResponseEntity<String> saveNotificationDetails(@Valid @RequestBody NotificationDto notificationDto) {

		NotificationDto dto = notificationServiceImpl.saveNotification(notificationDto);

		if (dto != null) {
			return new ResponseEntity<>("Details Added Sucessfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Samting Went Wromng", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/updateNotification")
	public ResponseEntity<String> updateNotificationDetails(@RequestParam("notificationId") String notificationId,
			@RequestBody NotificationDto notificationDto) {
		if (notificationId != null) {
			if (notificationServiceImpl.updateNotification(notificationId, notificationDto)) {
				return new ResponseEntity<>("Notification Details Updated Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Samthing Went Wrong", HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("Notification ID not Vaild", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/deleteNotification")
	public ResponseEntity<String> deleteNotificationDetails(@RequestParam("notificationId") String notificationId){
		if(notificationId!=null) {
			if(notificationServiceImpl.deleteNotification(notificationId)) {
				return new ResponseEntity<>("Data delete Successfully",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Samthing Went Wrong",HttpStatus.NOT_ACCEPTABLE);
			}
		}else {
			return new ResponseEntity<>("Notification ID not Vaild",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/getNotificationDetails")
	public List<Notification> getAllDetails(){
		return notificationServiceImpl.getNotification();
	}
}
