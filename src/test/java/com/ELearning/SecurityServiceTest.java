package com.ELearning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ELearning.DAO.LoginDao;
import com.ELearning.Service.SecurityServiceImp;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {
	
	@Mock
	private LoginDao loginDao;
	
	 @InjectMocks
	 private SecurityServiceImp securityService;
	 
	 private  LoginUser user;
	 
	 @BeforeEach
	    public  void setup(){
		 

	    	
	    	user = new LoginUser("abc.xyz1@gmail.com","AbcXyz12");
	    }
	 
	 @Test
	 public void securityServiceTest() {
		 user = new LoginUser("abc.xyz12@gmail.com","Abc@Xyz12");
		 
		 assertThat(securityService.getAuthToken(user)).isNotEmpty();
	 }
}
