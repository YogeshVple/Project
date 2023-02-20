package com.vst.transaction.service;

import java.util.List;

import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.model.Transaction;

public interface TransactionServiceInterface {

	public String add(TransactionDto transactionDto);
	
	public void edit(String transactionId, TransactionDto transactionDto);
	
	public void remove(String transactionId);
	
	List<Transaction> showAll();
}
