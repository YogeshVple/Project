package com.vst.booking.mongoConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

@Component
public class MongoConfig {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@PostConstruct
	public void createIndexes() {
		mongoTemplate.indexOps("booking").ensureIndex(new Index().on("bookingCustomerId",Sort.Direction.ASC));
	}

}
