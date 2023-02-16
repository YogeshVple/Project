package com.vst.notification.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationDto {

	@Transient
	public static final String SEQUENCE_NAME = "notification_sequence";
	
	@Id
	private String notificationId;
	@NotNull
	private String notificationCode;
	@NotNull
	private String notificationType;
	@NotNull
	private String notificationData;
	@NotNull
	private String createdDate;
	@NotNull
	private String modifiedDate;
	@NotNull
	private String createdBy;
	@NotNull
	private String modifiedBy;
	private boolean isActive;

}
