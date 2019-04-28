package com.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="Presenter")
public class Presenter {
	
	@Id
	@Column(name="presenter_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "presenters_sequence", allocationSize = 1, name = "CUST_SEQ")
	private Long id;
	
	@NotBlank(message="Presenter name cannot be empty")
	@Column(name="presenter_name")
	private String presenterName;
	
	@Column(name="contact_number")
	private String contactNumber;

}
