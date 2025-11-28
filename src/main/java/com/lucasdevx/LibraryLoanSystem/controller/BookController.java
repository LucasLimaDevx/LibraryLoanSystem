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

import com.lucasdevx.LibraryLoanSystem.dto.BookDTO;
import com.lucasdevx.LibraryLoanSystem.exception.ObjectIsNullException;
import com.lucasdevx.LibraryLoanSystem.model.Book;
import com.lucasdevx.LibraryLoanSystem.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookDTO insert(@RequestBody BookDTO bookDTO) {
		if(bookDTO == null) {
			throw new NullPointerException("Id is null");
		}
		
		Book book = bookService.insert( bookService.parseToBook(bookDTO));
		
		return bookService.parseToBookDTO(book);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookDTO getById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		Book book = bookService.getById(id);
		return bookService.parseToBookDTO(book);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookDTO> getAll(){
		List<Book> books = bookService.getAll();
		List<BookDTO> booksDTO = books.stream()
				.map((book) -> bookService.parseToBookDTO(book))
				.collect(Collectors.toList());
		
		return booksDTO;
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookDTO update(@RequestBody BookDTO bookDTO) {
		if(bookDTO == null) {
			throw new ObjectIsNullException();
		}
		if(bookDTO.id() == null) {
			throw new NullPointerException("Id is null");
		}
		if(bookDTO.id() <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		Book newBook = bookService.parseToBook(bookDTO);
		Book bookUpdated = bookService.update(newBook);
		
		return bookService.parseToBookDTO(bookUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
