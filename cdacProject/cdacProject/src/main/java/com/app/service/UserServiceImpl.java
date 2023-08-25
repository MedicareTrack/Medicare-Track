package com.app.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ApiResponse;
import com.app.DTO.UpdateDto;
import com.app.DTO.UserDto;
import com.app.DTO.UserDtoList;
import com.app.customexception.ResourceNotFoundException;
import com.app.entities.Carts;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepo;
@Autowired
private ModelMapper mapper;
@Autowired
private CartService cartSer;
	@Override
	// Add user details
	public ApiResponse addUserDetails(UserDto userDetails) {
		System.out.println("in service");
		User user = mapper.map(userDetails, User.class);
		 User newUser = userRepo.save(user);
		 if( newUser.getRole().equals(Role.CUSTOMER)) {
			 Carts cart = cartSer.addCartForUser(newUser);
			 newUser.setCart(cart);
		 }
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
	// update partial details of user
	public ApiResponse updatePartialDetails(UpdateDto user) {
		User userDetails = mapper.map(user, User.class);
		userRepo.save(userDetails);
		return new ApiResponse("details update successfully");
	}


	@Override
	 //getting list of all users
	public List<UserDtoList> getAllRegisterUsers() {
		List<User> list = userRepo.findAll();
		
		List<UserDtoList> userlist = new ArrayList<UserDtoList>();
		for(User user : list) {
			userlist.add(mapper.map(user, UserDtoList.class));
		}
         return userlist;
		
	} 

}
