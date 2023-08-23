package com.app.DTO;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class UserDto {
	@NotBlank(message = "First name can't be blank")
	private String firstName;
	@NotBlank(message = "last name can't be blank")
	private String lastName;
	@NotBlank(message = "email name can't be blank")
	@Email
	private String email;
	@NotBlank(message = "Mobile number should me 10 digit")
	@Length(min = 10,max = 10)
	private String mobileNumber;
	@NotBlank(message = "Password can't be blank")
	private String password;
	@NotBlank (message = "Password can't be blank")
	private String confirmPassword;
	
	private Role role;


}
