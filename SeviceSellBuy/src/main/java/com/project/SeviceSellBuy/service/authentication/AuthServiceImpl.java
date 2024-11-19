package com.project.SeviceSellBuy.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.dto.SignupRequestDTO;
import com.project.SeviceSellBuy.dto.UserDto;
import com.project.SeviceSellBuy.enums.UserRole;
import com.project.SeviceSellBuy.model.User;
import com.project.SeviceSellBuy.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;
	
	public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		
		user.setName(signupRequestDTO.getName());
		user.setLastname(signupRequestDTO.getLastname());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
		
		user.setRole(UserRole.CLIENT);
		
		return userRepository.save(user).getDto();
	}
	
	public Boolean presetByEmail(String email) {
		
		return userRepository.findFirstByEmail(email)!= null;
	}
	
	public UserDto signupCompany(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		
		user.setName(signupRequestDTO.getName());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()) );
		
		user.setRole(UserRole.COMPANY);
		
		return userRepository.save(user).getDto();
	}

}
