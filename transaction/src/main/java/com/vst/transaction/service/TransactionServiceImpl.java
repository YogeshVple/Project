package com.vst.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.transaction.conveter.TransactionConveter;
import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.exception.TransactionException;
import com.vst.transaction.model.Transaction;
import com.vst.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionServiceInterface {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	TransactionSequenceGeneratorService transactionSequenceGeneratorService;

	@Autowired
	TransactionConveter conveter;

	@Override
	public TransactionDto saveTransaction(TransactionDto transactionDto) {

		transactionDto.setTransactionId(transactionSequenceGeneratorService.idGen());
		transactionDto.setActive(true);

		Transaction obj = conveter.dtoToEntity(transactionDto);
		transactionRepository.save(obj);
		return conveter.entityToDto(obj);

	}

	@Override
	public boolean updateTransaction(String transactionId, TransactionDto transactionDto) {

		Transaction transaction = transactionRepository.findByTransactionIdAndIsActiveTrue(transactionId);

		Transaction obj = conveter.dtoToEntity(transactionDto);
		if (transaction != null) {
			if (transaction.getTransactionCustomerId() != null)
				obj.setTransactionCustomerId(transaction.getTransactionCustomerId());
			if (transaction.getTransactionHostId() != null)
				obj.setTransactionHostId(transaction.getTransactionHostId());
			if (transaction.getTransactionVendorId() != null)
				obj.setTransactionVendorId(transaction.getTransactionVendorId());
			if (transaction.getTransactionStationId() != null)
				obj.setTransactionStationId(transaction.getTransactionStationId());
			if (transaction.getTransactionStatus() != null)
				obj.setTransactionStatus(transaction.getTransactionStatus());
			if (transaction.getTransactionUTR() != null)
				obj.setTransactionUTR(transaction.getTransactionUTR());
			if (transaction.getTransactionDate() != null)
				obj.setTransactionDate(transaction.getTransactionDate());
			if (transaction.getTransactionTime() != null)
				obj.setTransactionTime(transaction.getTransactionTime());
			if (transaction.getTransactionAmount() != null)
				obj.setTransactionAmount(transaction.getTransactionAmount());
			if (transaction.getCreatedDate() != null)
				obj.setCreatedDate(transaction.getCreatedDate());
			if (transaction.getModifiedDate() != null)
				obj.setModifiedDate(transaction.getModifiedDate());
			if (transaction.getCreatedBy() != null)
				obj.setCreatedBy(transaction.getCreatedBy());
			if (transaction.getModifiedBy() != null)
				obj.setModifiedBy(transaction.getModifiedBy());

			transactionRepository.save(obj);

		} else {
			throw new TransactionException("Samthing Went Wrong");
		}
		return true;
	}

	@Override
	public boolean deleteTransaction(String transactionId) {

		Transaction obj = transactionRepository.findByTransactionIdAndIsActiveTrue(transactionId);
		if (obj != null) {
			obj.setActive(false);
			transactionRepository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public List<Transaction> getAllTrasaction() {
		return transactionRepository.findAllByIsActiveTrue();
	}

}
