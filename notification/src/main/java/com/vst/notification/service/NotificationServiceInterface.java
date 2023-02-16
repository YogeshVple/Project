package com.vst.notification.service;

import java.util.List;

import com.vst.notification.dto.NotificationDto;
import com.vst.notification.model.Notification;

public interface NotificationServiceInterface {

	public NotificationDto saveNotification(NotificationDto dto);
	
	public boolean updateNotification(String notificationId, NotificationDto dto);
	
	public boolean deleteNotification(String notificationId);
	
	public List<Notification> getNotification();
}
