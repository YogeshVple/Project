package com.vst.booking.service;

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

import com.vst.booking.dto.BookingDto;
import com.vst.booking.dto.BookingDbSequence;

@Service
public class BookingSequenceGeneratorService {

	@Autowired
	MongoOperations mongoOperations;

	public int getSequenceNumber(String sequenceName) {
		Query query = new Query(Criteria.where("id").is(sequenceName)); // update the sequence no
		Update update = new Update().inc("seq", 1); // modify in document
		BookingDbSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
				BookingDbSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

	public String idGen() {
		Date dNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
		return dateFormat.format(dNow) + getSequenceNumber(BookingDto.SEQUENCE_NAME);
	}
}
