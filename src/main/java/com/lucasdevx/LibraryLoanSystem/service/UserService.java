package com.lucasdevx.LibraryLoanSystem.service;

import java.util.List;

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
	
	public User getById(Long id) {
		
		return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id: " + id));
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User update(User user) {
		User currentUser = getById(user.getId());
		
		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		currentUser.setPhone(user.getPhone());
		
		return userRepository.save(currentUser);
		
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
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
