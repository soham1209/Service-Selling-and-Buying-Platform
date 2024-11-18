package com.project.SeviceSellBuy.service.authentication;

import com.project.SeviceSellBuy.dto.SignupRequestDTO;
import com.project.SeviceSellBuy.dto.UserDto;

public interface AuthService {

	UserDto signupClient(SignupRequestDTO signupRequestDTO);
	Boolean presetByEmail(String email);
	UserDto signupCompany(SignupRequestDTO signupRequestDTO);
}
