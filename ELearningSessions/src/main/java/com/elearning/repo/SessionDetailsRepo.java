package com.elearning.repo;

import org.springframework.data.repository.CrudRepository;

import com.elearning.model.SessionDetail;

public interface SessionDetailsRepo extends CrudRepository<SessionDetail, Long>{

	SessionDetail getById(Long id);
}
