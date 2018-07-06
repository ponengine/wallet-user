package com.pon.user.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserInfoDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String cityzenId;
	private LocalDateTime createDate;
	private String userName;
	private String password;
	private int pin;
	private String status;
}