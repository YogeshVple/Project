package com.vst.notification.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.validation.constraints.NotBlank;
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
	@NotNull @NotBlank
	private String notificationCode;
	@NotNull @NotBlank
	private String notificationType;
	@NotNull @NotBlank
	private String notificationData;
	@NotNull @NotBlank
	private String createdDate;
	@NotNull @NotBlank
	private String modifiedDate;
	@NotNull @NotBlank
	private String createdBy;
	@NotNull @NotBlank
	private String modifiedBy;
	private boolean isActive;

}
