package com.ELearning.controller;



import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.Service.MainService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ELearning.model.Interest;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

@RestController
@RequestMapping("/elearning/api")
@CrossOrigin(origins = "*")  
public class LoginController {




@Autowired
MainService mainService;
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> findUsr(@RequestBody LoginUser login) throws InvalidLogin{
		return new ResponseEntity<Map<String,String>>(mainService.loginUser(login.getUserName(), login.getPass()),HttpStatus.OK);
		
	}
	

	
	@PostMapping("/register")
	public ResponseEntity<RegisterUser> saveUser(@RequestBody RegisterUser registerUser) throws UserAlredyExists {
		return new ResponseEntity<RegisterUser>(mainService.signUpUser(registerUser),HttpStatus.CREATED);
		
	}
	
	@PatchMapping("changePassword/{userId}")
	public ResponseEntity<RegisterUser> loginUser(@PathVariable Integer userId,@RequestBody String newPassword) throws UserNotFound{
		return new ResponseEntity<RegisterUser>(mainService.changePassword(userId, newPassword),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userName}")
	public RegisterUser userData(@PathVariable String userName) throws Exception {
		return mainService.checkUser(userName);
		
	}
	
	@GetMapping("interest/{userId}")
	
	
	public @ResponseBody String checkInt(@PathVariable Integer userId) {
		
		return mainService.checkProf(userId);
		
	}
	
	@PostMapping("/saveInterest/{id}")
	public ResponseEntity<Interest> saveInt(@RequestBody List<Integer> req,@PathVariable Integer id)  {
		return new ResponseEntity<Interest>(mainService.saveInterest(req,id),HttpStatus.CREATED);
		
	}

}
