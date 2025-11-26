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

import com.lucasdevx.LibraryLoanSystem.dto.UserDTO;
import com.lucasdevx.LibraryLoanSystem.model.User;
import com.lucasdevx.LibraryLoanSystem.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO insert(@RequestBody UserDTO userDTO) {
		User user = userService.insert( userService.parseToUser(userDTO));
		
		return userService.parseToUserDTO(user);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getById(@PathVariable Long id) {
		User user = userService.getById(id);
		return userService.parseToUserDTO(user);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> getAll(){
		List<User> users = userService.getAll();
		List<UserDTO> usersDTO = users.stream()
				.map((user) -> userService.parseToUserDTO(user))
				.collect(Collectors.toList());
		
		return usersDTO;
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO update(@RequestBody UserDTO userDTO) {
		User newUser = userService.parseToUser(userDTO);
		User userUpdated = userService.update(newUser);
		
		return userService.parseToUserDTO(userUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
