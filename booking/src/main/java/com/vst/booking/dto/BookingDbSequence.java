package com.vst.booking.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="db_Sequence")
public class BookingDbSequence {

	@Id
    private String  id;
    private int seq;
}
