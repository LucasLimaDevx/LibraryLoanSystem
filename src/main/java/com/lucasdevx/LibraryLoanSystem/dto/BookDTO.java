package com.lucasdevx.LibraryLoanSystem.dto;

public record BookDTO(
		Long id, 
		String title, 
		String year, 
		Integer quantityCopies) {

}
