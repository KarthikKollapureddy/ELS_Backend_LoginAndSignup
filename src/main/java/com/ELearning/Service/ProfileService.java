package com.ELearning.Service;

import com.ELearning.model.ModeBean;
import com.ELearning.model.RegisterUser;

public interface ProfileService {

	ModeBean editMode(int id, int val);

	ModeBean checkMode(int id);

	RegisterUser editName(RegisterUser req, Integer id);

}
