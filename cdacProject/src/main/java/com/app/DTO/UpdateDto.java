package com.app.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UpdateDto {
	private Long id;
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
	

}
