package com.vst.notification.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.notification.dto.NotificationDto;
import com.vst.notification.model.Notification;

@Component
public class NotificationConverter {

	public Notification dtoToEntity(NotificationDto notificationDto) {
		Notification object = new Notification();
		BeanUtils.copyProperties(notificationDto, object);
		return object;
	}
	
	public NotificationDto entityToDto(Notification notification ) {

		NotificationDto object = new NotificationDto();
		BeanUtils.copyProperties(notification, object);
		return object;
	}
}

