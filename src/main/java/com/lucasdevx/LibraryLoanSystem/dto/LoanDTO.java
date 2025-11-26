package com.lucasdevx.LibraryLoanSystem.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record LoanDTO(
		Long id, 
		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
		LocalDateTime loanDate,

		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
		LocalDateTime returnDate) {

}
