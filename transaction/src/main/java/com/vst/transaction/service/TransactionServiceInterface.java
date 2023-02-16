package com.vst.transaction.service;

import java.util.List;

import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.model.Transaction;

public interface TransactionServiceInterface {

	public TransactionDto saveTransaction(TransactionDto transactionDto);
	
	public boolean updateTransaction(String transactionId, TransactionDto transactionDto);
	
	public boolean deleteTransaction(String transactionId);
	
	List<Transaction> getAllTrasaction();
}
