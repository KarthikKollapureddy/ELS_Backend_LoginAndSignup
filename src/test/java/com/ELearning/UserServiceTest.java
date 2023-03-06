package com.ELearning;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;

import com.ELearning.Exceptions.GlobalExceptionHandler;
import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.Service.MainServiceImpl;
import com.ELearning.Service.SecurityServiceImp;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;






import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;




import static org.mockito.BDDMockito.given;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private RegisterDao registerDao;

    @Mock
    private LoginDao loginDao;

    
    @InjectMocks
    private GlobalExceptionHandler exp;
    

    @InjectMocks
    private MainServiceImpl mainService;
    
    
    @Mock
    private SecurityServiceImp securityService;

    private RegisterUser user,user1;

    private LoginUser userLogin,userLogin1;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setup(){
    	user = new RegisterUser(1,"abc.xyz12@gmail.com","ABC","XYZ","Abc@Xyz12","984498393","2000-01-01","female",3);
    	user1 = new RegisterUser(1,"john.paul12@gmail.com","john","paul","John@Paul","9288593432","2000-02-03","male",2);

    	userLogin = new LoginUser("abc.xyz12@gmail.com","Abc@Xyz12");
    	userLogin1 = new LoginUser("abc.xyz1@gmail.com","AbcXyz12");
    }
   
    
    @Test
    public void givenExistingEmail_whenSaveEmployee() throws UserAlredyExists {

//        System.out.println(registerDao);
//        System.out.println(user);

        given(registerDao.save(user)).willReturn(user);

//        System.out.println(registerDao);
//        System.out.println(mainService);


        // when -  action or the behaviour that we are going test
        RegisterUser savedUser = mainService.signUpUser(user);


//        System.out.println(savedUser);

        //System.out.println(savedUser);

        // then - verify the output
        assertThat(savedUser).isNotNull();

    }

   
    @Test
    public void givenExistingEmail_whenSaveEmployee_thenThrowsException(){
        // given - precondition or setup
        given(registerDao.findByUserName(user.getUserName()))
                .willReturn(user);

//        System.out.println(registerDao);
//        System.out.println(mainService);

        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(UserAlredyExists.class, () -> {
            mainService.signUpUser(user);
        });

        // then
       // verify(registerDao, never()).save(any(RegisterUser.class));

    }

    
    @Test
    public void whenUpdateUserPassword_thenReturnUpdatedUserPassword() throws UserNotFound {
        // given - precondition or setup
//


       
        
       
        given(registerDao.findByUserId(user.getUserId()))
        .willReturn(user);
        given(loginDao.findByUserName(userLogin.getUserName()))
                .willReturn(userLogin);
//        System.out.println(user);
//        System.out.println(userLogin);

        // when -  action or the behaviour that we are going test
       
        
        
        RegisterUser updatedUser = mainService.changePassword(user.getUserId(),"Sarayu");
        // then - verify the output
        assertThat(updatedUser.getPass()).isEqualTo("Sarayu");

        


    }
    @Test
    public void whenUpdateUserPassword_thenReturnUpdatedUserPassword_thenThrowsException() throws UserNotFound {
//        given(registerDao.findRegisterUserByUserName(user.getUserName()))
//                .willReturn(user);

//        given(loginDao.findByUserName(userLogin1.getUserName()))
//                .willReturn(userLogin1);

        org.junit.jupiter.api.Assertions.assertThrows(UserNotFound.class,()->{
   		 mainService.changePassword(5, "Sarayu");
   	 });
       

    }
    @Test
    public void whenLoginUser_thenjwtTokenAndLoginDetils_thenThrowsException()  {
    	//given(mainService.loginUser(userLogin.getUserName(), user.getPass())).willReturn( throw new InvalidLogin);
      
//    	System.out.println(userLogin);
    	
//    	given(loginDao.findByUserNameAndPass(userLogin.getUserName(), userLogin1.getPass()))
//        .willReturn(null);
    	 org.junit.jupiter.api.Assertions.assertThrows(InvalidLogin.class,()->{
    		 mainService.loginUser(userLogin.getUserName(), userLogin1.getPass());
    	 });
         
    	
    }
    
    @Test
    public void whenLoginUser_thenjwtTokenAndLoginDetils() throws InvalidLogin {
    	given(loginDao.findByUserNameAndPass(userLogin.getUserName(), userLogin.getPass()))
        .willReturn(userLogin);
       	
//    	Map<String,String> token = mainService.loginUser(userLogin.getUserName(),userLogin.getPass());
    	
    	given(securityService.getAuthToken(userLogin)).willReturn(new HashMap<String,String>());
    	assertNotNull(mainService.loginUser(userLogin.getUserName(), userLogin.getPass()));
    	    	



        


    }





}
