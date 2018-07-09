package com.pon.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.pon.user.entity.UserLogin;



public interface UserLoginRepository extends CrudRepository<UserLogin, Long>{
	UserLogin findByUsername(String username);

}
