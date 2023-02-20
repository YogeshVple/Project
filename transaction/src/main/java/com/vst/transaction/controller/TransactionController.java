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
	public ResponseEntity<String> updateTrasaction(@RequestParam("transactioId") String transactioId,
			@RequestBody TransactionDto dto) {
		transactionServiceImpl.edit(transactioId, dto);
		return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/transaction")
	public ResponseEntity<String> delete(@RequestParam("transactioId") String transactioId) {
		transactionServiceImpl.remove(transactioId);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
	}

	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTrasaction() {
		return ResponseEntity.ok(transactionServiceImpl.showAll());
	}
}
