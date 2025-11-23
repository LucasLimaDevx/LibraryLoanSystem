package com.lucasdevx.LibraryLoanSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book extends JpaRepository<Book, Long>{

}
