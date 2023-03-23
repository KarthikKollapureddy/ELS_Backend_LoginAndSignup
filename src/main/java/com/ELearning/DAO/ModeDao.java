package com.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ELearning.model.ModeBean;

@Repository
public interface ModeDao extends JpaRepository<ModeBean, Integer> {

	boolean existsByUserId(int id);

	ModeBean findByUserId(int id);

}
