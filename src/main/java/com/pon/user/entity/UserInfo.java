package com.pon.user.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserInfo implements Serializable{
	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String citizenId;
	private LocalDate createDate;
	private LocalDate updateDate;
	private int pin;
	private String userName;
	private String status;
	@Email
	private String email;
	
	public UserInfo() {
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userlogin_id")
	private UserLogin userlogin;
	
}
