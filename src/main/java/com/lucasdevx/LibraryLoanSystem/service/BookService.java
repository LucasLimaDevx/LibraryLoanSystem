package com.lucasdevx.LibraryLoanSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdevx.LibraryLoanSystem.dto.BookDTO;
import com.lucasdevx.LibraryLoanSystem.model.Book;
import com.lucasdevx.LibraryLoanSystem.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book insert(Book book) {
		
		return bookRepository.save(book);
	}
	
	public Book getById(Long id) {
		
		return bookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id: " + id));
	}
	
	public List<Book> getAll(){
		return bookRepository.findAll();
	}
	
	public Book update(Book book) {
		Book currentBook = getById(book.getId());
		
		
		currentBook.setTitle(book.getTitle());
		currentBook.setYear(book.getYear());
		currentBook.setQuantityCopies(book.getQuantityCopies());
		
		return bookRepository.save(currentBook);
		
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	public Book parseToBook(BookDTO bookDTO) {
		Book book = new Book();
	
		book.setId(bookDTO.id());
		book.setTitle(bookDTO.title());
		book.setYear(bookDTO.year());
		book.setQuantityCopies(bookDTO.quantityCopies());
		
		return book;
	}
	
	public BookDTO parseToBookDTO(Book book) {
		return new BookDTO(
				book.getId(),
				book.getTitle(),
				book.getYear(),
				book.getQuantityCopies());
		
	}
}
