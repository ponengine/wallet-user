package com.pon.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pon.user.entity.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	UserInfo findByUserName(String username);
	@Query("select u from UserInfo u where u.createDate = CURDATE()")
	List<UserInfo> findByDateTody();
}
