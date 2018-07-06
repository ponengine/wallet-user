package com.pon.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pon.user.dto.UserInfoDTO;
import com.pon.user.entity.UserInfo;
import com.pon.user.repository.UserInfoRepository;




@RestController
@RequestMapping("/report")
public class UserTransactionController {
	@Autowired
	private UserInfoRepository usernfoRepository;
	static ModelMapper modelMapper = new ModelMapper();
	@GetMapping("/showuserall")
	public List<UserInfoDTO> showAll(){
		List<UserInfoDTO> listdto = new ArrayList<>();
		Iterable<UserInfo> listtran = usernfoRepository.findAll();
		for (UserInfo tranReport : listtran) {
			UserInfoDTO tranReports = new UserInfoDTO();
			try {
				tranReports = modelMapper.map(tranReport, UserInfoDTO.class);
				listdto.add(tranReports);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return listdto;
	}
	@GetMapping("/showusertoday")
	public List<UserInfoDTO> showUsetToday(){
		List<UserInfoDTO> listdto = new ArrayList<>();
		Iterable<UserInfo> listtran = usernfoRepository.findByDateTody();
		for (UserInfo tranReport : listtran) {
			UserInfoDTO tranReports = new UserInfoDTO();
			try {
				tranReports = modelMapper.map(tranReport, UserInfoDTO.class);
				listdto.add(tranReports);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return listdto;
	}

}
