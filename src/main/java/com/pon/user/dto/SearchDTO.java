package com.pon.user.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SearchDTO {
	private LocalDate startDate;
	private LocalDate endDate;
	
}
