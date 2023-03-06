package com.ELearning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ELearning.DAO.RegisterDao;
import com.ELearning.model.RegisterUser;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegisterRepoTest {
	
	@Autowired
    private RegisterDao registerRepo;

    private RegisterUser reg;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setup(){
        reg = new RegisterUser("abc.xyz12@gmail.com","ABC","XYZ","Abc@Xyz12","984498393","2000-01-01","female",3);
                
    }
    
    @Test
    public void givenUserObject_whenSave_thenReturnSavedUser(){

        //given - precondition or setup
        @SuppressWarnings("deprecation")
		RegisterUser reg = new RegisterUser("abc.xyz12@gmail.com","ABC","XYZ","Abc@Xyz12","984498393","2000-01-01","female",3);
        // when - action or the behaviour that we are going test
        RegisterUser savedUser = registerRepo.save(reg);

        // then - verify the output
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserId()).isGreaterThan(0);
    }
    
    @Test
    public void givenUsersList_whenFindAll_thenUsersList(){
        // given - precondition or setup

    	
		RegisterUser reg1 = new RegisterUser("john.paul12@gmail.com","john","paul","John@Paul","9288593432","2000-02-03","male",2);

        registerRepo.save(reg);
        registerRepo.save(reg1);

        // when -  action or the behaviour that we are going test
        List<RegisterUser> userList = registerRepo.findAll();

        // then - verify the output
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
//
//    }

}
    @Test
    public void givenUserObject_whenFindByUserName_thenReturnUserObject(){

        registerRepo.save(reg);

        // when -  action or the behaviour that we are going test
        Optional<RegisterUser> userDB = Optional.ofNullable(registerRepo.findByUserName(reg.getUserName()));

        // then - verify the output
        assertThat(userDB).isNotNull();
    }
    
    @Test
    public void givenUserObject_whenFindByUserNameAndPass_thenReturnUserObject(){

        registerRepo.save(reg);

        // when -  action or the behaviour that we are going test
        Optional<RegisterUser> userDB1 = Optional.ofNullable(registerRepo.findByUserNameAndPass(reg.getUserName(),reg.getPass()));

        // then - verify the output
        assertThat(userDB1).isNotNull();
    }
    
    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser(){

        registerRepo.save(reg);

        // when -  action or the behaviour that we are going test
        RegisterUser savedUser = registerRepo.findByUserName(reg.getUserName());
        savedUser.setPass("AbcXyz12");
        
        RegisterUser updatedUser =  registerRepo.save(savedUser);

        // then - verify the output
        assertThat(updatedUser.getPass()).isEqualTo("AbcXyz12");
        
    }
}
