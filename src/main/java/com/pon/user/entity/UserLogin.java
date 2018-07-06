package com.pon.user.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserLogin implements Serializable{
	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	
	
	
	public UserLogin() {
	}
	@OneToOne(mappedBy="userlogin")
	private UserInfo userinfo;


	
}
