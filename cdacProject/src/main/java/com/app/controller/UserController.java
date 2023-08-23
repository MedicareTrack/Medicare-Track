package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.UpdateDto;
import com.app.DTO.UserDto;
import com.app.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userSer;
	
	@PostMapping("/register")
	public ResponseEntity<?> addUserDetails( @RequestBody @Valid UserDto user){
		System.out.println("in controller");
		if(user.getPassword().equals(user.getConfirmPassword())) {
			return ResponseEntity.status(HttpStatus.OK).body(userSer.addUserDetails(user));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("password should be same");
		}
		
	}
	
	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable Long ID){
		return ResponseEntity.status(HttpStatus.OK).body(userSer.deleteUserDeails(ID));
	}
	
	@PatchMapping
	public ResponseEntity<?> updateUserDetails(UpdateDto user){
		return ResponseEntity.status(HttpStatus.OK).body(userSer.updatePartialDetails(user));
	}
}
