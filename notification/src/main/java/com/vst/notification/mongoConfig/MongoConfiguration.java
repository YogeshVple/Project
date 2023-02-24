package com.vst.notification.mongoConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MongoConfiguration {

	@Autowired
	MongoTemplate mongoTemplate;

	@PostConstruct
	public void createIndexes() {
//		mongoTemplate.indexOps("notification").ensureIndex(new Index().on("bookingCustomerId",Sort.Direction.ASC));
	}

}
