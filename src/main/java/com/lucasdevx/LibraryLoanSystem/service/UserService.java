package com.lucasdevx.LibraryLoanSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdevx.LibraryLoanSystem.dto.UserDTO;
import com.lucasdevx.LibraryLoanSystem.model.User;
import com.lucasdevx.LibraryLoanSystem.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User insert(User user) {
		
		return userRepository.save(user);
	}
	
	public User parseToUser(UserDTO userDTO) {
		User user = new User();
		
		user.setId(userDTO.id());
		user.setName(userDTO.name());
		user.setEmail(userDTO.email());
		user.setPhone(userDTO.phone());
		
		return user;
	}
	
	public UserDTO parseToUserDTO(User user) {
		return new UserDTO(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getPhone());
		
	}
	
}
