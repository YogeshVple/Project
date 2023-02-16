package com.vst.station.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vst.station.dto.StationDbSequence;
import com.vst.station.dto.StationDto;

@Service
public class StationSequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;
	
	public int getSequenceNumber(String sequenceName) {
		
        Query query = new Query (Criteria.where("id").is(sequenceName));  //update the sequence no       
        Update update = new Update().inc("seq", 1); //modify in document   
        StationDbSequence counter = mongoOperations.findAndModify(query, update,options().returnNew(true).upsert(true),StationDbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
	
	
	public String idGen() {
		Date dNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
		return dateFormat.format(dNow)+"_"+getSequenceNumber(StationDto.SEQUENCE_NAME);
	}
		
}	
		
		
		
		
		