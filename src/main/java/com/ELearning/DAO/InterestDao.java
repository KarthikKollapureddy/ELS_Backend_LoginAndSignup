package com.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ELearning.model.Interest;

public interface InterestDao extends JpaRepository<Interest, Integer> {

	Interest findByUserId(int userId);

}
