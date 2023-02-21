package com.vst.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.model.Transaction;
import com.vst.transaction.service.TransactionServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vst1")
public class TransactionController {

	@Autowired
	TransactionServiceImpl transactionServiceImpl;

	@PostMapping("/transaction")
	@Validated
	public ResponseEntity<String> saveTransaction(@Valid @RequestBody TransactionDto transactionDto) {
		transactionServiceImpl.add(transactionDto);
		return new ResponseEntity<>("Transaction Successful", HttpStatus.OK);
	}

	@PutMapping("/transaction")
	public ResponseEntity<String> updateTransaction(@RequestParam("transactioId") String transactioId,
			@RequestBody TransactionDto dto) {
		transactionServiceImpl.edit(transactioId, dto);
		return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/transaction")
	public ResponseEntity<String> deleteTransaction(@RequestParam("transactioId") String transactioId) {
		transactionServiceImpl.remove(transactioId);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
	}

	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		return ResponseEntity.ok(transactionServiceImpl.showAll());
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTrasactionCustomer(@RequestParam("transactioCustomerId") String transactioCustomerId) {
		return ResponseEntity.ok(transactionServiceImpl.getByTransactionCustomerId(transactioCustomerId));
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTrasactionHost(@RequestParam("transactioHostId") String transactioHostId) {
		return ResponseEntity.ok(transactionServiceImpl.getByTransactionHostId(transactioHostId));
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTrasactionVendor(@RequestParam("transactioVendorId") String transactioVendorId) {
		return ResponseEntity.ok(transactionServiceImpl.getByTransactionVendorId(transactioVendorId));
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTrasactionStation(@RequestParam("transactioStationId") String transactioStationId) {
		return ResponseEntity.ok(transactionServiceImpl.getByTransactionStationId(transactioStationId));
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTrasactionStatus(@RequestParam("transactioStatus") String transactioStatus) {
		return ResponseEntity.ok(transactionServiceImpl.getByTransactionStatus(transactioStatus));
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTrasactionUTR(@RequestParam("transactioUTR") String transactioUTR) {
		return ResponseEntity.ok(transactionServiceImpl.getByTransactionUTRId(transactioUTR));
	}
	
}
