package com.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.ModeDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.model.LoginUser;
import com.ELearning.model.ModeBean;
import com.ELearning.model.RegisterUser;

@Service
public class ProfileServiceImp implements ProfileService{
	
	@Autowired ModeDao modDao;
	@Autowired RegisterDao regDao;
//	@Autowired LoginDao logDao;

	@Override
	public ModeBean editMode(int id, int val) {
		// TODO Auto-generated method stub
		ModeBean mod=modDao.findByUserId(id);
		mod.setVal(val);
		return modDao.saveAndFlush(mod);
	}

	@Override
	public ModeBean checkMode(int id) {
		// TODO Auto-generated method stub
		return modDao.findByUserId(id);
	}

	@Override
	public RegisterUser editName(RegisterUser req, Integer id) {
		// TODO Auto-generated method stub
//		LoginUser log=logDao.findByUserId(id);
//		log.setUserName(req.getUserName());
//		logDao.saveAndFlush(log);
		return regDao.saveAndFlush(req);
	}
	

}
