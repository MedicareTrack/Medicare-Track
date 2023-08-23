package com.app.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@Getter
@Setter
public class User extends BaseEntity {
	@Column(name = "first_name" , length = 20, nullable = false)
	private String firstName;
	@Column(name = "last_name" , length = 20 ,nullable = false)
	private String lastName;
	@Column(name = "email" , length = 30,unique = true , nullable = false)
	private String email;
	@Column(name = "mobile_number" , length = 10 , nullable = false)
	private String mobileNumber;
	@Column(name = "password" , length = 20 , nullable = false)
	private String password;
	@Transient
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

}
