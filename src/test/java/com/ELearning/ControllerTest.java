package com.ELearning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.Service.MainService;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private MainService mainService;

	    @Autowired
	    private ObjectMapper objectMapper;
	    
	    private RegisterUser user;

	    private LoginUser log,log1;
	    
	    @SuppressWarnings("deprecation")
		@BeforeEach
	    public void setup(){
	    	user = new RegisterUser("abc.xyz12@gmail.com","ABC","XYZ","Abc@Xyz12","984498393","2000-01-01","female",3);

	    	log = new LoginUser("abc.xyz12@gmail.com","Abc@Xyz12");
	    	log1 = new LoginUser("abc.xyz1@gmail.com","AbcXyz12");
	    }
	    
	    @Test
	    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{

	        // given - precondition or setup
	    	 @SuppressWarnings("deprecation")
			RegisterUser reg = new RegisterUser("abc.xyz12@gmail.com","ABC","XYZ","Abc@Xyz12","984498393","2000-01-01","female",3);
	        given(mainService.signUpUser(any(RegisterUser.class)))
	                .willAnswer((invocation)-> invocation.getArgument(0));

	        // when - action or behaviour that we are going test
	        ResultActions response = mockMvc.perform(post("/elearning/api/register")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(reg)));

	        // then - verify the result or output using assert statements
	        response.andDo(print()).
	                andExpect(status().isCreated())
	                .andExpect(jsonPath("$.userName",
	                		is(reg.getUserName())))
	                .andExpect(jsonPath("$.firstName",
	                        is(reg.getFirstName())))
	                .andExpect(jsonPath("$.lastName",
	                        is(reg.getLastName())))
	                .andExpect(jsonPath("$.pass",
	                        is(reg.getPass())))
	                .andExpect(jsonPath("$.role",
	                        is(reg.getRole())));

	    }
	    
	    @Test
	    public void givenUserNameAndPass_whenGetLoginByUserNameAndPass_thenReturnUserObject() throws Exception{
	        // given - precondition or setup
	        

	    	
	    	given(mainService.loginUser(log.getUserName(), log.getPass())).willReturn(new HashMap<String,String>());
	        ResultActions response = mockMvc.perform(post("/elearning/api/login").contentType(MediaType.APPLICATION_JSON)
		            .content(objectMapper.writeValueAsString(log)));

	        // then - verify the output
	        response.andExpect(status().isOk());
//	                .andDo(print());
//	                .andExpect(jsonPath("$.userName", is(log.getUserName())))
//	                .andExpect(jsonPath("$.pass", is(log.getPass())));
	               

	    }
//}
	    
//	    @Test
//	    public void givenInvalidUserNameAndPass_whenGetEmployeeByUserNameAndPass_thenReturnEmpty() throws Exception{
//	        // given - precondition or setup
// 
//	    	 
//	    	given(mainService.loginUser(log.getUserName(), log1.getPass())).willReturn(new HashMap<String,String>());
//	        ResultActions response = mockMvc.perform(post("/elearning/api/signin").contentType(MediaType.APPLICATION_JSON)
//		            .content(objectMapper.writeValueAsString(log)));
//
//	        // when -  action or the behaviour that we are going test
//	       
//
//	        // then - verify the output
//	        response.andExpect(status().isNotFound());
//	        
////	        org.junit.jupiter.api.Assertions.assertThrows(InvalidLogin.class, () -> {
////	            mainService.loginUser(log.getUserName(),log1.getPass());
////	        });
//	                //.andDo(print());
//	    }
	    
	    @Test
	    public void whenValidId_thenChangePass_Returns201() throws Exception {
	      
	      
	       mockMvc.perform(patch("/elearning/api/changePassword/{userId}",0)
	            .contentType("application/json")
	            .param("AbcXyz12", "true")
	            .content(objectMapper.writeValueAsString((log))))
	            .andExpect(status().isOk());
	    }
	    
//	    @Test
//	    public void whenInvalidId_thenChangePass_ReturnsError() throws Exception {
//	      
//	      
////	       mockMvc.perform(patch("/elearning/api/changePassword/{userName}", "abc.xyz@gmail.com")
////	            .contentType("application/json")
////	            .param("AbcXyz12", "true")
////	            .content(objectMapper.writeValueAsString((log))))
////	            .andExpect(status().isBadRequest());
//	       org.junit.jupiter.api.Assertions.assertThrows(UserNotFound.class, () -> {
//	    	   mockMvc.perform(patch("/elearning/api/changePassword/{userName}", "abc.xyz@gmail.com")
//	    			   .contentType("application/json")
//	    			   .param("AbcXyz12","true")
//	    			   .content(objectMapper.writeValueAsString(log)));
//          
//       });
//	    }
}
