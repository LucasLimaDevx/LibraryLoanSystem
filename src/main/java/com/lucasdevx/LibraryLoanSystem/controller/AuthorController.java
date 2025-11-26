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

import com.lucasdevx.LibraryLoanSystem.dto.AuthorDTO;
import com.lucasdevx.LibraryLoanSystem.model.Author;
import com.lucasdevx.LibraryLoanSystem.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthorDTO insert(@RequestBody AuthorDTO authorDTO) {
		Author author = authorService.insert( authorService.parseToAuthor(authorDTO));
		
		return authorService.parseToAuthorDTO(author);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthorDTO getById(@PathVariable Long id) {
		Author author = authorService.getById(id);
		return authorService.parseToAuthorDTO(author);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AuthorDTO> getAll(){
		List<Author> authors = authorService.getAll();
		List<AuthorDTO> authorsDTO = authors.stream()
				.map((author) -> authorService.parseToAuthorDTO(author))
				.collect(Collectors.toList());
		
		return authorsDTO;
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthorDTO update(@RequestBody AuthorDTO authorDTO) {
		Author newAuthor = authorService.parseToAuthor(authorDTO);
		Author authorUpdated = authorService.update(newAuthor);
		
		return authorService.parseToAuthorDTO(authorUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		authorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
