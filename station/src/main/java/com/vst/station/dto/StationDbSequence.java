package com.vst.station.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="db_sequence")
public class StationDbSequence {

	@Id
    private String  id;
    private int seq;
}
