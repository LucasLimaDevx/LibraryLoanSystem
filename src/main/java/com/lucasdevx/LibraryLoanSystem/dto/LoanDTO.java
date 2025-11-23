package com.lucasdevx.LibraryLoanSystem.dto;

import java.time.LocalDateTime;

public record LoanDTO(Long id, LocalDateTime loanDate, LocalDateTime returnDate) {

}
