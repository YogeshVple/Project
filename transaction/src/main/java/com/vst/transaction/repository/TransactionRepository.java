package com.vst.transaction.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.transaction.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

	Transaction findByTransactionIdAndIsActiveTrue(String transactionId);

	List<Transaction> findAllByIsActiveTrue();

	Transaction findByTransactionCustomerIdAndIsActiveTrue(String transactionCustomerId);

	Transaction findByTransactionHostIdAndIsActiveTrue(String transactionHostId);

	Transaction findByTransactionVendorIdAndIsActiveTrue(String transactionVendorId);

	Transaction findByTransactionStationIdAndIsActiveTrue(String transactionStationId);

	Transaction findByTransactionStatusAndIsActiveTrue(String transactionStatus);

	Transaction findByTransactionUTRAndIsActiveTrue(String transactionUTR);

}
