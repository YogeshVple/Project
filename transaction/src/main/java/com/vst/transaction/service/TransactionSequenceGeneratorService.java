package com.vst.transaction.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vst.transaction.dto.TransactionDto;
import com.vst.transaction.dto.TransactionDbSequence;

@Service
public class TransactionSequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public int getSequenceNumber(String sequenceName) {

		Query query = new Query(Criteria.where("id").is(sequenceName)); // update the sequence no
		Update update = new Update().inc("seq", 1); // modify in document
		TransactionDbSequence counter = mongoOperations.findAndModify(query, update,
				options().returnNew(true).upsert(true), TransactionDbSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

	public String idGen() {
		Date dNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
		return  dateFormat.format(dNow)+ "_" + getSequenceNumber(TransactionDto.SEQUENCE_NAME);
	}
}
