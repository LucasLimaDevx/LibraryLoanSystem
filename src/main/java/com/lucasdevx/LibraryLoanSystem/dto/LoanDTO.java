package com.lucasdevx.LibraryLoanSystem.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasdevx.LibraryLoanSystem.model.Book;
import com.lucasdevx.LibraryLoanSystem.model.User;

public record LoanDTO(
		Long id, 
		
		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
		LocalDateTime loanDate,
		
		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
		LocalDateTime returnDate,
		User user,
		Book book) {

}
