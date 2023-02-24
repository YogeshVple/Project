package com.vst.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.notification.converter.NotificationConverter;
import com.vst.notification.dto.NotificationDto;
import com.vst.notification.exception.NotificationIdNotAcceptableException;
import com.vst.notification.exception.NotificationNotFoundException;
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
	
	private String string = "Please Enter Vaild Data";

	@Override
	public String add(NotificationDto notificationDto) {

		notificationDto.setNotificationId(notificationSequenceService.idGen());
		notificationDto.setActive(true);
		Notification notification = notificationConverter.dtoToEntity(notificationDto);
		notificationRepository.save(notification);
		return "Data added";
	}

	@Override
	public void edit(String notificationId, NotificationDto notificationDto) {

		if (!notificationId.isBlank()) {

			Notification obj = notificationRepository.findByNotificationIdAndIsActiveTrue(notificationId);

			Notification notification = notificationConverter.dtoToEntity(notificationDto);

			if (obj != null) {
				
				if (notification.getNotificationCode() != null && !notification.getNotificationCode().isBlank())
						obj.setNotificationCode(notification.getNotificationCode());

				if (notification.getNotificationType()!= null && !notification.getNotificationType().isBlank())
						obj.setNotificationType(notification.getNotificationType());

				if (notification.getNotificationData() != null && !notification.getNotificationData().isBlank())
						obj.setNotificationData(notification.getNotificationData());

				if (notification.getCreatedDate() != null && !notification.getCreatedDate().isBlank())
						obj.setCreatedDate(notification.getCreatedDate());

				if (notification.getModifiedDate() != null && !notification.getModifiedDate().isBlank())
						obj.setModifiedDate(notification.getModifiedDate());

				if (notification.getCreatedBy() != null && !notification.getCreatedBy().isBlank())
						obj.setCreatedBy(notification.getCreatedBy());

				if (notification.getModifiedBy() != null && !notification.getModifiedBy().isBlank())
						obj.setModifiedBy(notification.getModifiedBy());

				notificationRepository.save(obj);
			} else {
				throw new NotificationNotFoundException("No Notification Found");
			}

		} else {
			throw new NotificationIdNotAcceptableException(string);
		}
	}

	@Override
	public void remove(String notificationId) {

		if (!notificationId.trim().isEmpty()) {

			Notification obj = notificationRepository.findByNotificationIdAndIsActiveTrue(notificationId);

			if (obj != null) {
				obj.setActive(false);
				notificationRepository.save(obj);

			} else
				throw new NotificationNotFoundException("No Notification Found");
		} else
			throw new NotificationIdNotAcceptableException(string);
	}

	@Override
	public List<Notification> showAll() {
		
		List<Notification> list = notificationRepository.findAllByIsActiveTrue();
		if(!list.isEmpty()) {
			return list;
		}else {
			throw new NotificationNotFoundException("No Data Found");
		}
	}

	@Override
	public Notification show(String notificationId) {
		if (!notificationId.trim().isBlank()) {
			Notification obj = notificationRepository.findByNotificationIdAndIsActiveTrue(notificationId);
			if (obj != null) {
				return obj;
			} else {
				throw new NotificationNotFoundException("No Data Found");
			}
		} else {
			throw new NotificationIdNotAcceptableException(string);
		}

	}

	@Override
	public List<Notification> getByNotificationCode(String notificationCode) {

		if (!notificationCode.trim().isEmpty()) {
			List<Notification> list = notificationRepository.findByNotificationCodeAndIsActiveTrue(notificationCode);
			if (!list.isEmpty()) {
				return list;
			} else {
				throw new NotificationNotFoundException("No Data Found");
			}
		} else {
			throw new NotificationIdNotAcceptableException(string);
		}
	}

	@Override
	public List<Notification> getByNotificationType(String notificationType) {
		if (!notificationType.trim().isEmpty()) {
			List<Notification> list = notificationRepository.findByNotificationCodeAndIsActiveTrue(notificationType);
			if (!list.isEmpty()) {
				return list;
			} else {
				throw new NotificationNotFoundException("No Data Found");
			}
		} else {
			throw new NotificationIdNotAcceptableException(string);
		}
	}
}
