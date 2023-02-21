package com.vst.notification.service;

import java.util.List;

import com.vst.notification.dto.NotificationDto;
import com.vst.notification.model.Notification;

public interface NotificationServiceInterface {

	public String add(NotificationDto dto);
	
	public void edit(String notificationId, NotificationDto dto);
	
	public void remove(String notificationId);
	
	public List<Notification> showAll();
	
	public Notification show(String notificationId);
	
	public List<Notification> getByNotificationCode(String notificationCode);
	
	public List<Notification> getByNotificationType(String notificationType);
}
