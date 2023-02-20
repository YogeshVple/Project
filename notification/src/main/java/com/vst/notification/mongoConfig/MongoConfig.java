package com.vst.notification.mongoConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MongoConfig {

	@Autowired
	MongoTemplate mongoTemplate;

	@PostConstruct
	public void createIndexes() {
//		mongoTemplate.indexOps("booking").ensureIndex(new Index().on("bookingCustomerId",Sort.Direction.ASC));
	}

}
