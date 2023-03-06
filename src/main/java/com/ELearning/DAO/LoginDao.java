package com.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ELearning.model.LoginUser;

@Repository
public interface LoginDao extends JpaRepository<LoginUser, Integer> {
//	@Query("select a from LoginBean a where a.userName=(:name) and a.pass=(:pass)")
//	LoginBean findLoginBeanByUserNameAndPass(@Param("name")String username,@Param("pass")String pwd);

	LoginUser findByUserNameAndPass(String username,String pwd);
	
	LoginUser findByUserName(String userName);

}
