package com.elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.model.SessionDetail;
import com.elearning.repo.SessionDetailsRepo;

@Service
public class SessionDetailsService {

	@Autowired
	private SessionDetailsRepo sessionDetailsRepo;
	
	public SessionDetail saveOrUpdateSessionDetails(SessionDetail sessionDetail) {
		if(sessionDetail.getSessionStatus()==null || sessionDetail.getSessionStatus()=="")
			sessionDetail.setSessionStatus("TO_DO");
		return sessionDetailsRepo.save(sessionDetail);
	}
	
	public Iterable<SessionDetail> getAllSessionDetails() {
		return sessionDetailsRepo.findAll();
	}
	
	public SessionDetail findById(Long id) {
		return sessionDetailsRepo.getById(id);
	}
	
	public void delete(SessionDetail deleteSession) {
		sessionDetailsRepo.delete(deleteSession);
	}
}
