package com.vst.transaction.mongoConfig;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MongoConfig {

	@Autowired
	MongoTemplate mongoTemplate;

	@PostConstruct
	public void createIndexes() {
		mongoTemplate.indexOps("station").ensureIndex(new Index().on("stationId",Sort.Direction.ASC));
	}

}
