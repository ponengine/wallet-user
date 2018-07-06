package com.pon.user.service;

import java.time.LocalDate;

import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.pon.user.constant.Role;
import com.pon.user.dto.UserInfoDTO;
import com.pon.user.entity.UserInfo;
import com.pon.user.entity.UserLogin;
import com.pon.user.repository.UserInfoRepository;
import com.pon.user.repository.UserLoginRepository;

@Service
public class UserService {
	@Autowired
	private Environment env;
	@Autowired
	private UserInfoRepository userinforepository;
	
	LocalDate lc = LocalDate.now();
	ModelMapper modelmapper = new ModelMapper();
	public String addProfileUser(UserInfoDTO userInfoDTO) {
		final String URI = env.getProperty("wallet.uri")+"/managewallet/newuser";
		RestTemplate rt = new RestTemplate();
		UserLogin userlogin = new UserLogin();
		UserInfo userinfo = new UserInfo();
		userlogin.setUsername(userInfoDTO.getUserName());
		userlogin.setPassword(userInfoDTO.getPassword());
		userinfo.setCityzenId(userInfoDTO.getCityzenId());
		userinfo.setFirstName(userInfoDTO.getFirstName());
		userinfo.setLastName(userInfoDTO.getLastName());
		userinfo.setPin(userInfoDTO.getPin());
		userinfo.setCreateDate(lc);
		userinfo.setUserName(userInfoDTO.getUserName());
		userinfo.setStatus(Role.USER.toString());
		userinfo.setUserlogin(userlogin);
		userinforepository.save(userinfo);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject obj = new JSONObject();
		obj.put("usernameBuyer", userlogin.getUsername());		
		HttpEntity<String> entity = new HttpEntity<String>(obj.toString() ,headers);

		String response = rt.postForObject( URI, entity , String.class );
		return response;
	}
	public String deleteuser(String username) {
		userinforepository.delete(userinforepository.findByUserName(username));
		return "Success";
	}
	public UserInfoDTO getuser(String username) {
		UserInfo userinfo=userinforepository.findByUserName(username);
		UserInfoDTO userdto =modelmapper.map(userinfo, UserInfoDTO.class);
		return userdto;
	}

}
