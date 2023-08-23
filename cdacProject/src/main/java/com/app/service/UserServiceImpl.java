package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.ResourceAccessException;

import com.app.DTO.UserDto;
import com.app.DTO.ApiResponse;
import com.app.DTO.UpdateDto;
import com.app.entities.User;
import com.app.exc_handler.ResourceNotFoundException;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepo;
@Autowired
private ModelMapper mapper;
	@Override
	// Add user details
	public ApiResponse addUserDetails(UserDto userDetails) {
		System.out.println("in service");
		User user = mapper.map(userDetails, User.class);
		 userRepo.save(user);
		return new ApiResponse("Successfully added");
	}
	
	
	@Override
	// delete existing user
	public ApiResponse deleteUserDeails(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not Found"));
		userRepo.delete(user);
		return new ApiResponse("User Details Deleted Successfully");
	}


	@Override
	public ApiResponse updatePartialDetails(UpdateDto user) {
		User userDetails = mapper.map(user, User.class);
		userRepo.save(userDetails);
		return new ApiResponse("details update successfully");
	}

}
