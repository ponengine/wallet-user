package com.pon.user.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pon.user.dto.UserInfoDTO;
import com.pon.user.entity.UserLogin;
import com.pon.user.service.UserService;


@RestController
@RequestMapping("/usermanage")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(value="/adduser")
	public String addUser(@RequestBody UserInfoDTO userInfoDTO) {	
		return userservice.addProfileUser(userInfoDTO);
	}
	@PostMapping("/deleteuser")
	public String deleteUser(@RequestBody UserInfoDTO userInfoDTO){
		return userservice.deleteuser(userInfoDTO);
	}
	public String  updateUser(@RequestBody UserInfoDTO userInfoDTO){
		return userservice.updateUser(userInfoDTO);
	}
	@GetMapping("/getuser/{username}")
	public UserInfoDTO getUser(@PathVariable("username")String username){
		return userservice.getuser(username);
	}
	public String changePassword(@RequestBody UserInfoDTO userInfoDTO){
		return userservice.changePassword(userInfoDTO);
	}
	

}
