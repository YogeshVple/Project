package com.vst.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.transaction.conveter.TransactionConveter;
import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.exception.TransactionIdNotAcceptableException;
import com.vst.transaction.exception.TransactionNotFoundException;
import com.vst.transaction.model.Transaction;
import com.vst.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionServiceInterface {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	TransactionSequenceGeneratorService transactionSequenceGeneratorService;

	@Autowired
	TransactionConveter transactionConveter;

	@Override
	public String add(TransactionDto transactionDto) {

		transactionDto.setTransactionId(transactionSequenceGeneratorService.idGen());
		transactionDto.setActive(true);
		Transaction obj = transactionConveter.dtoToEntity(transactionDto);
		transactionRepository.save(obj);
		return "Data Added";

	}

	@Override
	public void edit(String transactionId, TransactionDto transactionDto) {

		if (!transactionId.isBlank()) {

			Transaction transaction = transactionRepository.findByTransactionIdAndIsActiveTrue(transactionId);

			Transaction obj = transactionConveter.dtoToEntity(transactionDto);
			if (transaction != null) {

				if (transaction.getTransactionCustomerId() != null)
					if (!transaction.getTransactionCustomerId().isBlank())
						obj.setTransactionCustomerId(transaction.getTransactionCustomerId());

				if (transaction.getTransactionHostId() != null)
					if (!transaction.getTransactionHostId().isBlank())
						obj.setTransactionHostId(transaction.getTransactionHostId());

				if (transaction.getTransactionVendorId() != null)
					if (!transaction.getTransactionVendorId().isBlank())
						obj.setTransactionVendorId(transaction.getTransactionVendorId());

				if (transaction.getTransactionStationId() != null)
					if (!transaction.getTransactionStationId().isBlank())
						obj.setTransactionStationId(transaction.getTransactionStationId());

				if (transaction.getTransactionStatus() != null)
					if (!transaction.getTransactionStationId().isBlank())
						obj.setTransactionStatus(transaction.getTransactionStatus());

				if (transaction.getTransactionUTR() != null)
					if (!transaction.getTransactionUTR().isBlank())
						obj.setTransactionUTR(transaction.getTransactionUTR());

				if (transaction.getTransactionDate() != null)
					if (!transaction.getTransactionDate().isBlank())
						obj.setTransactionDate(transaction.getTransactionDate());

				if (transaction.getTransactionTime() != null)
					if (!transaction.getTransactionTime().isBlank())
						obj.setTransactionTime(transaction.getTransactionTime());

				if (transaction.getTransactionAmount() != null)
					if (!transaction.getTransactionAmount().isBlank())
						obj.setTransactionAmount(transaction.getTransactionAmount());

				if (transaction.getCreatedDate() != null)
					if (!transaction.getCreatedDate().isBlank())
						obj.setCreatedDate(transaction.getCreatedDate());

				if (transaction.getModifiedDate() != null)
					if (!transaction.getModifiedDate().isBlank())
						obj.setModifiedDate(transaction.getModifiedDate());

				if (transaction.getCreatedBy() != null)
					if (!transaction.getCreatedBy().isBlank())
						obj.setCreatedBy(transaction.getCreatedBy());

				if (transaction.getModifiedBy() != null)
					if (!transaction.getModifiedBy().isBlank())
						obj.setModifiedBy(transaction.getModifiedBy());

				transactionRepository.save(obj);

			} else {
				throw new TransactionNotFoundException("Not Found");
			}
		} else {
			throw new TransactionIdNotAcceptableException("Invaild ID");
		}
	}

	@Override
	public void remove(String transactionId) {

		if (!transactionId.trim().isBlank()) {
			Transaction obj = transactionRepository.findByTransactionIdAndIsActiveTrue(transactionId);
			if (obj != null) {
				obj.setActive(false);
				transactionRepository.save(obj);
			} else {
				throw new TransactionNotFoundException("Not Found");
			}
		} else {
			throw new TransactionIdNotAcceptableException("Invaild ID");
		}
	}

	@Override
	public List<Transaction> showAll() {

		List<Transaction> list = transactionRepository.findAllByIsActiveTrue();

		if (!list.isEmpty()) {
			return list;
		} else {
			throw new TransactionNotFoundException("No Data");
		}
	}

}
