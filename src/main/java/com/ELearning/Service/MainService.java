package com.ELearning.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.model.Interest;
import com.ELearning.model.LoginUser;
import com.ELearning.model.ModeBean;
//import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

@Service

public interface MainService
{
	
	public Map<String, String> loginUser(String userName,String pass) throws InvalidLogin;
	
	public RegisterUser signUpUser(RegisterUser registerUser) throws UserAlredyExists;

	public RegisterUser changePassword(Integer userId,String newPassword) throws UserNotFound;

	public RegisterUser checkUser(String userName) throws UserNotFound;
	
	public String checkProf(int userId);

	public Interest saveInterest(List<Integer> req,int id);

	public Interest getIntrst(Integer userId);

	public RegisterUser findUser(Integer userId) throws UserNotFound;

	Map<String, String> interests(int id);

	public ModeBean saveMode(int id, int val) throws Exception;

	public Interest editInterest(List<Integer> req, Integer id) throws Exception;

	public List<RegisterUser> search(String val);

	

	

}
