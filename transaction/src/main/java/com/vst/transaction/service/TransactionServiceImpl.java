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
	
	String string = "No Data Found"; 

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

				if (transaction.getTransactionCustomerId() != null && !transaction.getTransactionCustomerId().isBlank())
					obj.setTransactionCustomerId(transaction.getTransactionCustomerId());

				if (transaction.getTransactionHostId() != null && !transaction.getTransactionHostId().isBlank())
					obj.setTransactionHostId(transaction.getTransactionHostId());

				if (transaction.getTransactionVendorId() != null && !transaction.getTransactionVendorId().isBlank())
					obj.setTransactionVendorId(transaction.getTransactionVendorId());

				if (transaction.getTransactionStationId() != null && !transaction.getTransactionStationId().isBlank())

					obj.setTransactionStationId(transaction.getTransactionStationId());

				if (transaction.getTransactionStatus() != null && !transaction.getTransactionStationId().isBlank())

					obj.setTransactionStatus(transaction.getTransactionStatus());

				if (transaction.getTransactionUTR() != null && !transaction.getTransactionUTR().isBlank())

					obj.setTransactionUTR(transaction.getTransactionUTR());

				if (transaction.getTransactionDate() != null && !transaction.getTransactionDate().isBlank())

					obj.setTransactionDate(transaction.getTransactionDate());

				if (transaction.getTransactionTime() != null && !transaction.getTransactionTime().isBlank())

					obj.setTransactionTime(transaction.getTransactionTime());

				if (transaction.getTransactionAmount() != null && !transaction.getTransactionAmount().isBlank())

					obj.setTransactionAmount(transaction.getTransactionAmount());

				if (transaction.getCreatedDate() != null && !transaction.getCreatedDate().isBlank())

					obj.setCreatedDate(transaction.getCreatedDate());

				if (transaction.getModifiedDate() != null && !transaction.getModifiedDate().isBlank())
					obj.setModifiedDate(transaction.getModifiedDate());

				if (transaction.getCreatedBy() != null && !transaction.getCreatedBy().isBlank())

					obj.setCreatedBy(transaction.getCreatedBy());

				if (transaction.getModifiedBy() != null && !transaction.getModifiedBy().isBlank())

					obj.setModifiedBy(transaction.getModifiedBy());

				transactionRepository.save(obj);

			} else {
				throw new TransactionNotFoundException(string);
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
				throw new TransactionNotFoundException(string);
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
			throw new TransactionNotFoundException(string);
		}
	}

	@Override
	public Transaction show(String transactionId) {
		if (!transactionId.trim().isEmpty()) {
			Transaction transaction = transactionRepository.findByTransactionIdAndIsActiveTrue(transactionId);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

	@Override
	public Transaction getByTransactionCustomerId(String transactionCustomerId) {
		if (!transactionCustomerId.trim().isEmpty()) {
			Transaction transaction = transactionRepository
					.findByTransactionCustomerIdAndIsActiveTrue(transactionCustomerId);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

	@Override
	public Transaction getByTransactionHostId(String transactionHostId) {
		if (!transactionHostId.trim().isEmpty()) {
			Transaction transaction = transactionRepository.findByTransactionHostIdAndIsActiveTrue(transactionHostId);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

	@Override
	public Transaction getByTransactionVendorId(String transactionVendorId) {
		if (!transactionVendorId.trim().isEmpty()) {
			Transaction transaction = transactionRepository
					.findByTransactionVendorIdAndIsActiveTrue(transactionVendorId);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

	@Override
	public Transaction getByTransactionStationId(String transactionStationId) {
		if (!transactionStationId.trim().isEmpty()) {
			Transaction transaction = transactionRepository
					.findByTransactionStationIdAndIsActiveTrue(transactionStationId);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

	@Override
	public Transaction getByTransactionStatus(String transactionStatus) {
		if (!transactionStatus.trim().isEmpty()) {
			Transaction transaction = transactionRepository.findByTransactionStatusAndIsActiveTrue(transactionStatus);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

	@Override
	public Transaction getByTransactionUTRId(String transactionUTR) {
		if (!transactionUTR.trim().isEmpty()) {
			Transaction transaction = transactionRepository.findByTransactionUTRAndIsActiveTrue(transactionUTR);
			if (transaction != null) {
				return transaction;
			} else {
				throw new TransactionNotFoundException(string);
			}
		} else {
			throw new TransactionIdNotAcceptableException("Not acceptable");
		}
	}

}
