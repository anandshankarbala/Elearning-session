package com.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="session_detail")
public class SessionDetail {
	
	@Id
	@Column(name="session_detail_id")
	@GeneratedValue
	private Long id;
	
	@NotBlank(message="Session name cannot be empty")
	@Column(name="session_title")
	private String sessionTitle;
	
	@Column(name="session_summary")
	private String sessionSummary;
	
	@Column(name="session_status")
	private String sessionStatus;

}
