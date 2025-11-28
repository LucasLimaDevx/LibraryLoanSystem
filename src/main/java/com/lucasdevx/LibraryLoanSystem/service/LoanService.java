package com.lucasdevx.LibraryLoanSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdevx.LibraryLoanSystem.dto.LoanDTO;
import com.lucasdevx.LibraryLoanSystem.model.Loan;
import com.lucasdevx.LibraryLoanSystem.repository.LoanRepository;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepository;
	
	public Loan insert(Loan loan) {
		
		return loanRepository.save(loan);
	}
	
	public Loan getById(Long id) {
		
		return loanRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id: " + id));
	}
	
	public List<Loan> getAll(){
		return loanRepository.findAll();
	}
	
	public Loan update(Loan loan) {
		Loan currentLoan = getById(loan.getId());
		
		currentLoan.setLoanDate(loan.getLoanDate());
		currentLoan.setReturnDate(loan.getReturnDate());
		
		return loanRepository.save(currentLoan);
		
	}
	
	public void delete(Long id) {
		getById(id);
		
		loanRepository.deleteById(id);
	}
	public Loan parseToLoan(LoanDTO loanDTO) {
		Loan loan = new Loan();
		
		loan.setId(loanDTO.id());
		loan.setLoanDate(loanDTO.loanDate());
		loan.setReturnDate(loanDTO.returnDate());
		
		return loan;
	}
	
	public LoanDTO parseToLoanDTO(Loan loan) {
		return new LoanDTO(
				loan.getId(),
				loan.getLoanDate(),
				loan.getReturnDate());
		
	}
}
