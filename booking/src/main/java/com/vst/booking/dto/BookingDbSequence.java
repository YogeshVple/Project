package com.vst.booking.dto;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


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
    private Integer seq;
}
