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
import com.vst.transaction.exception.TransactionException;
import com.vst.transaction.model.Transaction;
import com.vst.transaction.service.TransactionServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionServiceImpl transactionServiceImpl;

	@PostMapping("/addTransaction")
	@Validated
	public ResponseEntity<String> saveTransactionDetails(@Valid @RequestBody TransactionDto transactionDto) {

		TransactionDto obj = transactionServiceImpl.saveTransaction(transactionDto);
		if (obj != null) {
			return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Samthing Went Wrong", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/updateTransaction")
	public ResponseEntity<String> updateTrasactionDetails(@RequestParam("transactioId") String transactioId,
			@RequestBody TransactionDto dto) {
		if (transactioId != null) {
			if (transactionServiceImpl.updateTransaction(transactioId, dto)) {
				return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Samthing Went Wrong", HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("Wrong ID", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("/deleteTransaction")
	public ResponseEntity<String> deleteDetails(@RequestParam("transactioId") String transactioId) {
		if (transactioId != null) {
			if (transactionServiceImpl.deleteTransaction(transactioId)) {
				return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("Wrong ID", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Transaction>> getAllTrasaction() {

		List<Transaction> list = transactionServiceImpl.getAllTrasaction();
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			throw new TransactionException("No Data Found");
		}
	}
}
