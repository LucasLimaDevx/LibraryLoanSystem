package com.lucasdevx.LibraryLoanSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public UserDTO insert(@RequestBody UserDTO userDTO) {
		User user = userService.insert( userService.parseToUser(userDTO));
		
		return userService.parseToUserDTO(user);
	}
}
