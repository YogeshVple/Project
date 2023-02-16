package com.vst.transaction.conveter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.model.Transaction;

@Component
public class TransactionConveter {

	
	public Transaction dtoToEntity(TransactionDto transactionDto  ) {
		Transaction object = new Transaction();
		BeanUtils.copyProperties(transactionDto, object);
		return object;
	}
	
	public TransactionDto entityToDto(Transaction transaction ) {

		TransactionDto object = new TransactionDto();
		BeanUtils.copyProperties(transaction, object);
		return object;
	}
}
