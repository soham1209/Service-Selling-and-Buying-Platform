package com.project.SeviceSellBuy.service.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		com.project.SeviceSellBuy.model.User user = userRepository.findFirstByEmail(email);
		
		if (user == null) throw new UsernameNotFoundException("User not Found",null);
		return new User(user.getEmail(),user.getPassword(),new ArrayList<>());
	}

}
