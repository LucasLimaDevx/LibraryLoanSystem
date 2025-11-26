package com.lucasdevx.LibraryLoanSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdevx.LibraryLoanSystem.dto.AuthorDTO;
import com.lucasdevx.LibraryLoanSystem.model.Author;
import com.lucasdevx.LibraryLoanSystem.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author insert(Author author) {
		
		return authorRepository.save(author);
	}
	
	public Author getById(Long id) {
		
		return authorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id: " + id));
	}
	
	public List<Author> getAll(){
		return authorRepository.findAll();
	}
	
	public Author update(Author author) {
		Author currentAuthor = getById(author.getId());
		
		currentAuthor.setName(author.getName());
		currentAuthor.setNationality(author.getNationality());
		
		
		return authorRepository.save(currentAuthor);
		
	}
	
	public void delete(Long id) {
		authorRepository.deleteById(id);
	}
	public Author parseToAuthor(AuthorDTO authorDTO) {
		Author author = new Author();
		
		author.setId(authorDTO.id());
		author.setName(authorDTO.name());
		author.setNationality(authorDTO.nationality());
		
		return author;
	}
	
	public AuthorDTO parseToAuthorDTO(Author author) {
		return new AuthorDTO(
				author.getId(),
				author.getName(),
				author.getNationality());
		
	}
	
}
