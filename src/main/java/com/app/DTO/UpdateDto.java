package com.app.DTO;



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
