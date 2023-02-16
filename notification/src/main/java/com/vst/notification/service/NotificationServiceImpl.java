package com.vst.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.notification.converter.NotificationConverter;
import com.vst.notification.dto.NotificationDto;
import com.vst.notification.exception.NotificationException;
import com.vst.notification.model.Notification;
import com.vst.notification.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationServiceInterface {

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	NotificationConverter notificationConverter;

	@Autowired
	NotificationSequenceGeneratorService notificationSequenceService;

	@Override
	public NotificationDto saveNotification(NotificationDto notificationDto) {

		notificationDto.setNotificationId(notificationSequenceService.idGen());
		notificationDto.setActive(true);

		Notification obj = notificationConverter.dtoToEntity(notificationDto);

		notificationRepository.save(obj);
			return notificationConverter.entityToDto(obj);
	}

	@Override
	public boolean updateNotification(String notificationId, NotificationDto notificationDto) {

		Notification obj = notificationRepository.findByNotificationIdAndIsActiveTrue(notificationId);

		Notification notification = notificationConverter.dtoToEntity(notificationDto);

		if (obj != null) {
			if (notification.getNotificationCode() != null)
				obj.setNotificationCode(notification.getNotificationCode());
			if (notification.getNotificationType() != null)
				obj.setNotificationType(notification.getNotificationType());
			if (notification.getNotificationData() != null)
				obj.setNotificationData(notification.getNotificationData());
			if (notification.getCreatedDate() != null)
				obj.setCreatedDate(notification.getCreatedDate());
			if (notification.getModifiedDate() != null)
				obj.setModifiedDate(notification.getModifiedDate());
			if (notification.getCreatedBy() != null)
				obj.setCreatedBy(notification.getCreatedBy());
			if (notification.getModifiedBy() != null)
				obj.setModifiedBy(notification.getModifiedBy());

			notificationRepository.save(obj);
		} else {
			throw new NotificationException("Wrong Details");
		}
		return true;
	}

	@Override
	public boolean deleteNotification(String notificationId) {

		Notification obj = notificationRepository.findByNotificationIdAndIsActiveTrue(notificationId);

		if (obj != null) {
			obj.setActive(false);
			notificationRepository.save(obj);
			return true;
		} else
			return false;
	}

	@Override
	public List<Notification> getNotification() {
		return notificationRepository.findAllByIsActiveTrue();

	}
}
