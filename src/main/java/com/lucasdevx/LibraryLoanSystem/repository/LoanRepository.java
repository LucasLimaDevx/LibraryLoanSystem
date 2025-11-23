package com.lucasdevx.LibraryLoanSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdevx.LibraryLoanSystem.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
