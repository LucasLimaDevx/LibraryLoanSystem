package com.lucasdevx.LibraryLoanSystem.dto;

public record BookSummaryDTO(Long id, 
		String title, 
		String year, 
		Integer quantityCopies) {

}
