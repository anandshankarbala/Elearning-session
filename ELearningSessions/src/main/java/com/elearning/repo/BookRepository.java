package com.elearning.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.elearning.model.Presenter;

@RepositoryRestResource(path = "presenterData")
public interface BookRepository extends JpaRepository<Presenter, Long>{
}