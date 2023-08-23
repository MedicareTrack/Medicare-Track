package com.app.service;

import com.app.DTO.UserDto;
import com.app.DTO.ApiResponse;
import com.app.DTO.UpdateDto;

public interface UserService {
	ApiResponse addUserDetails(UserDto userDetails);
	
	ApiResponse deleteUserDeails(Long id);
	
	ApiResponse updatePartialDetails(UpdateDto user);

}
