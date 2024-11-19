package com.project.SeviceSellBuy.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.repository.AdRepository;
import com.project.SeviceSellBuy.repository.UserRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdRepository adRepository;
	
}
