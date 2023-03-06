package com.ELearning.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserAlredyExists.class)
	public ResponseEntity<String> userAlredyExists(){
		return new ResponseEntity<String>("User already exists",HttpStatus.CONFLICT);
	}

	@ExceptionHandler(InvalidLogin.class)
	public ResponseEntity<String> invalidLogin(){
		return new ResponseEntity<String>("invalid login details",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserNotFound.class )
	public ResponseEntity<String> userNotFound(){
		return new ResponseEntity<String>("User not found",HttpStatus.BAD_REQUEST);
	}
}
