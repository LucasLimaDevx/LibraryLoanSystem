package com.lucasdevx.LibraryLoanSystem.dto;

import com.lucasdevx.LibraryLoanSystem.model.Author;

public record BookDTO(
		Long id, 
		String title, 
		String year, 
		Integer quantityCopies,
		Author author) {

}
