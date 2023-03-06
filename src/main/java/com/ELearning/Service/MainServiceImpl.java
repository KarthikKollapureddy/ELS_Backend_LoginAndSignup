package com.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ELearning.DAO.InterestDao;
import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.model.Interest;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MainServiceImpl implements MainService {
  
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	InterestDao intDao;
	
	@Autowired
	SecurityService securityService;
	
	@Override
	public Map<String,String> loginUser(String userName, String pass) throws InvalidLogin {
		// TODO Auto-generated method stub
		LoginUser user = loginDao.findByUserNameAndPass(userName, pass);
		
		if(user != null) {
			Map<String, String> tokenMap = securityService.getAuthToken(user);
			
			return tokenMap;
		}
		
		throw new InvalidLogin();
		
		 
	}


	@Override
	public RegisterUser signUpUser(RegisterUser registerUser) throws UserAlredyExists {
		// TODO Auto-generated method student
		Optional<RegisterUser> user = Optional.ofNullable(registerDao.findByUserName(registerUser.getUserName()));
		if(user.isEmpty()) {
			registerDao.save(registerUser);
			LoginUser loginData = new LoginUser(registerUser.getUserName(), registerUser.getPass());
			loginDao.save(loginData);
			return registerUser;
		}
//		else if(user != null) {
//			throw new UserAlredyExists();
//		}
		else {
			throw new UserAlredyExists();
		}
	}


	@Override
	public RegisterUser changePassword(Integer userId, String newPassword) throws UserNotFound {
		// TODO Auto-generated method stub

		

//		System.out.println(userName);
		RegisterUser user1 = registerDao.findByUserId(userId);
		if(user1 == null) {
			throw new UserNotFound();
		}
		LoginUser userLogin1 = loginDao.findByUserName(user1.getUserName());
		
			
		
			userLogin1.setPass(newPassword);
				user1.setPass(newPassword);
			registerDao.saveAndFlush(user1);
			loginDao.saveAndFlush(userLogin1);

			return user1;
		


		
	}


	@Override
	public RegisterUser checkUser(String userName) throws UserNotFound {
		// TODO Auto-generated method stub
		RegisterUser reg=registerDao.findByUserName(userName);
		if(reg!=null) {
			return reg;
		}
		throw new UserNotFound();
	}


	@Override
	public String checkProf(int userId) {
		// TODO Auto-generated method stub
		Interest res= intDao.findByUserId(userId);
		if(res!=null) {
			return "{\"test\": \"Success\"}";
		}
		return "{\"test\": \"Fail\"}";
	}


	@Override
	public Interest saveInterest(List<Integer> req,int id) {
		// TODO Auto-generated method stub
		
		Interest res=new Interest(req.get(0),req.get(1),req.get(2),id);
		return intDao.save(res);
	}


	
	}
	
	


	

	

