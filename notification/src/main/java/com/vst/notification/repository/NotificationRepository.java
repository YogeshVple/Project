package com.vst.notification.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.notification.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
	
	Notification findByNotificationIdAndIsActiveTrue(String notificationId);

	List<Notification> findAllByIsActiveTrue();
	
	List<Notification> findByNotificationCodeAndIsActiveTrue(String notificationCode);
	
	List<Notification> findByNotificationTypeAndIsActiveTrue(String notificationType);
}
