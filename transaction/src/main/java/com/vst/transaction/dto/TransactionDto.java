
package com.vst.transaction.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
	
	@Transient
	public static final String SEQUENCE_NAME = "transaction_sequence";
	
	@Id
	@NotNull
	private String transactionId;
	@NotNull
	private String transactionCustomerId;
	@NotNull
	private String transactionHostId;
	@NotNull
	private String transactionVendorId;
	@NotNull
	private String transactionStationId;
	@NotNull
	private String transactionStatus;
	@NotNull
	private String transactionUTR;
	@NotNull
	private String transactionDate;
	@NotNull
	private String transactionTime;
	@NotNull
	private String transactionAmount;
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
