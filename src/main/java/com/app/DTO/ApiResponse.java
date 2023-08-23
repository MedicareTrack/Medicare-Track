package com.app.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
	
	private String message;
	private LocalDateTime localdatetime;
	public ApiResponse( String msg) {
		localdatetime = LocalDateTime.now();
		message = msg;
	}

}
