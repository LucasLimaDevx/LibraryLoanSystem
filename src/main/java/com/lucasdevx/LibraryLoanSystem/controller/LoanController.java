package com.lucasdevx.LibraryLoanSystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdevx.LibraryLoanSystem.dto.LoanDTO;
import com.lucasdevx.LibraryLoanSystem.exception.ObjectIsNullException;
import com.lucasdevx.LibraryLoanSystem.model.Loan;
import com.lucasdevx.LibraryLoanSystem.service.LoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDTO insert(@RequestBody LoanDTO loanDTO) {
		if(loanDTO == null) {
			throw new NullPointerException("Id is null");
		}
		Loan loan = loanService.insert( loanService.parseToLoan(loanDTO));
		
		return loanService.parseToLoanDTO(loan);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDTO getById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		Loan loan = loanService.getById(id);
		return loanService.parseToLoanDTO(loan);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LoanDTO> getAll(){
		List<Loan> loans = loanService.getAll();
		List<LoanDTO> loansDTO = loans.stream()
				.map((loan) -> loanService.parseToLoanDTO(loan))
				.collect(Collectors.toList());
		
		return loansDTO;
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanDTO update(@RequestBody LoanDTO loanDTO) {
		if(loanDTO == null) {
			throw new ObjectIsNullException();
		}
		if(loanDTO.id() == null) {
			throw new NullPointerException("Id is null");
		}
		if(loanDTO.id() <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		Loan newLoan = loanService.parseToLoan(loanDTO);
		Loan loanUpdated = loanService.update(newLoan);
		
		return loanService.parseToLoanDTO(loanUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		loanService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
