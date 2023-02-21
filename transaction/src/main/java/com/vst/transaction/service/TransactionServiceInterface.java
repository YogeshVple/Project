package com.vst.transaction.service;

import java.util.List;

import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.model.Transaction;

public interface TransactionServiceInterface {

	public String add(TransactionDto transactionDto);
	
	public void edit(String transactionId, TransactionDto transactionDto);
	
	public void remove(String transactionId);
	
	List<Transaction> showAll();
	
	Transaction show(String transactionId);
	
	Transaction getByTransactionCustomerId(String transactionCustomerId);
	
	Transaction getByTransactionHostId(String transactionHostId);
	
	Transaction getByTransactionVendorId(String transactionVendorId);

	Transaction getByTransactionStationId(String transactionStationId);

	Transaction getByTransactionStatus(String transactionStatus);

	Transaction getByTransactionUTRId(String transactionUTR);

}
