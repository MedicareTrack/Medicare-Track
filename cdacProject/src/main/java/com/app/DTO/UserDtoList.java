package com.app.DTO;



import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserDtoList {
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String password;
	private Role role;
}
