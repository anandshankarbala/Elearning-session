package com.elearning.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.SessionDetail;
import com.elearning.service.SessionDetailsService;
import com.elearning.util.CustomErrorType;

@RestController
//@CrossOrigin
@RequestMapping("/api/session")
public class SessionDetailsController {
	
	private final static Logger log = LoggerFactory.getLogger(SessionDetailsController.class);
	
	@Autowired
	private SessionDetailsService sessionService;
	
	@GetMapping(value = "/all")
	public Iterable<SessionDetail> getAllSessionDetails(){
		log.info("allSessionDetails info");
		return sessionService.getAllSessionDetails();
	}
	
	@GetMapping(value = "/{sd_id}")
	public ResponseEntity<?> getAllSessionDetailById(@PathVariable("sd_id") Long sd_id){
		log.info("get SessionDetail by id");
		SessionDetail sessionDetail = sessionService.findById(sd_id);
		if(sessionDetail==null) {
			log.error("Unable to get. User with id {} not found.", sd_id);
			return new ResponseEntity(new CustomErrorType("Unable to get SessionDetail with id " + sd_id + " not found."),
                    HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SessionDetail>(sessionDetail,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addSessionDetails(@Valid @RequestBody SessionDetail sessionDetail,BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage ));
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		
		SessionDetail newsessionD = sessionService.saveOrUpdateSessionDetails(sessionDetail);
		return new ResponseEntity<SessionDetail>(newsessionD,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{sd_id}")
	public ResponseEntity<?> deleteSessionDetails(@PathVariable("sd_id") Long sd_id){
		log.info("delete SessionDetail by id");
		SessionDetail deleteSession = sessionService.findById(sd_id);
		if(deleteSession==null) {
			log.error("Unable to delete. User with id {} not found.", sd_id);
			return new ResponseEntity(new CustomErrorType("Unable to delete SessionDetail with id " + sd_id + " not found."),
                    HttpStatus.NOT_FOUND);
		}
		sessionService.delete(deleteSession);
		return new ResponseEntity<SessionDetail>(HttpStatus.NO_CONTENT);
		
	}

}
