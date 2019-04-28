package com.elearning.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.Presenter;
import com.elearning.repo.PresenterCrudRepo;

@RestController
@CrossOrigin
@RequestMapping("/api/presenter")
public class PresenterController {
	
	private final static Logger log = LoggerFactory.getLogger(PresenterController.class);
	
	@Autowired
	private PresenterCrudRepo presenterCrudRepo;
	
	@GetMapping(value = "/all")
	public List<Presenter> getAllPresenters(){
		log.info("allPresenters info");
		List<Presenter> presenters =  (List<Presenter>) presenterCrudRepo.findAll();
		return presenters;
	}
	

}
