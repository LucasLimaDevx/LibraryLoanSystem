package com.lucasdevx.LibraryLoanSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdevx.LibraryLoanSystem.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
