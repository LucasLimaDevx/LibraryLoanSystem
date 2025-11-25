package com.lucasdevx.LibraryLoanSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdevx.LibraryLoanSystem.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
