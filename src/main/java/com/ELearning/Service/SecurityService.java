package com.ELearning.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ELearning.model.LoginUser;

@Service
public interface SecurityService {
	
	Map<String,String> getAuthToken(LoginUser log);

}
