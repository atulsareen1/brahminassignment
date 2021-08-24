package com.java.brahminassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatementDto {
	private int id;
	private String account_id;
	private String date_field;
	private String amount;
}