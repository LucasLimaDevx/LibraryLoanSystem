package com.lucasdevx.LibraryLoanSystem.dto;

import java.util.Set;

public record AuthorDTO(
		Long id,
		String name, 
		String nationality,
		Set<BookSummaryDTO> books) {

}
