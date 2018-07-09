package com.pon.user.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pon.user.entity.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	UserInfo findByUserName(String username);
	@Query("select u from UserInfo u where u.createDate = CURDATE()")
	List<UserInfo> findByDateTody();
	@Query("select u from UserInfo u where u.createDate between ?1 and ?2 ")
	List<UserInfo> findBySearch(LocalDate st,LocalDate ed);
	UserInfo findByEmail(String email);
}
