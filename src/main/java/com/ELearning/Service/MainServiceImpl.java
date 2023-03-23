package com.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ELearning.DAO.InterestDao;
import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.ModeDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.model.Interest;
import com.ELearning.model.LoginUser;
import com.ELearning.model.ModeBean;
import com.ELearning.model.RegisterUser;

import coms.Admin.bean.Subjects;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
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
	ModeDao modDao;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	RestTemplate restTemplate;
	
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


	@Override
	public Interest getIntrst(Integer userId) {
		// TODO Auto-generated method stub
	return intDao.findByUserId(userId);
	}


	@Override
	public RegisterUser findUser(Integer userId) throws UserNotFound {
		// TODO Auto-generated method stub
		RegisterUser reg=registerDao.findByUserId(userId);
		if(reg!=null) {
			return reg;
		}
		throw new UserNotFound();
	}
	
	@Override
	public Map<String, String> interests(int id) {
		// TODO Auto-generated method stub
		Interest intrst= intDao.findByUserId(id);
		Subjects sub1,sub2,sub3;
		sub1=restTemplate.getForObject("http://localhost:8787/elearning/api/admin/getSubject/"+intrst.getIntrst1(), Subjects.class);
		sub2=restTemplate.getForObject("http://localhost:8787/elearning/api/admin/getSubject/"+intrst.getIntrst2(), Subjects.class);
		sub3=restTemplate.getForObject("http://localhost:8787/elearning/api/admin/getSubject/"+intrst.getIntrst3(), Subjects.class);
		Map<String,String> res=new HashMap<>();
		
		res.put("interest1", sub1.getSubName());
		res.put("interest2", sub2.getSubName());
		res.put("interest3", sub3.getSubName());
		
		return res;
		
	}


	@Override
	public ModeBean saveMode(int id, int val) throws Exception {
		// TODO Auto-generated method stub
		ModeBean mod=new ModeBean(val,id);
		if(!modDao.existsByUserId(id)) {
		return modDao.save(mod);
	}
		throw new Exception("Already added");

	}


	@Override
	public Interest editInterest(List<Integer> req, Integer id) throws Exception {
		// TODO Auto-generated method stub
		if(intDao.existsByUserId(id)) {
			Interest res1=intDao.findByUserId(id);
		 		 res1.setIntrst1(req.get(0));
		 res1.setIntrst2(req.get(1));
		 res1.setIntrst3(req.get(2));
		return intDao.saveAndFlush(res1);
		}
		throw new Exception("Error");
	}


	@Override
	public List<RegisterUser> search(String val) {
		// TODO Auto-generated method stub
		List<RegisterUser> res=registerDao.findAll();
		List<RegisterUser> fres=new ArrayList<RegisterUser>();
		for(RegisterUser reg:res) {
			if(reg.getFirstName().contains(val) || reg.getLastName().contains(val)) {
				fres.add(reg);
			}
		}
		return fres;
	}

	
	}
	
	


	

	

