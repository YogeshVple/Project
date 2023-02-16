package com.vst.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="transaction")
public class Transaction {

	@Id
	private String transactionId;
	private String transactionCustomerId;
	private String transactionHostId;
	private String transactionVendorId;
	private String transactionStationId;
	private String transactionStatus;
	private String transactionUTR;
	private String transactionDate;
	private String transactionTime;
	private String transactionAmount;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private boolean isActive;

}
