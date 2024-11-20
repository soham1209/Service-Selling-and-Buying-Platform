package com.project.SeviceSellBuy.service.company;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.model.Ad;
import com.project.SeviceSellBuy.model.User;
import com.project.SeviceSellBuy.repository.AdRepository;
import com.project.SeviceSellBuy.repository.UserRepository;



@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdRepository adRepository;
	
	public boolean postAd (Long userId, AdDTO adDTO) throws IOException {
		Optional<User> optionalUser = userRepository.findById(userId);
		if(optionalUser.isPresent()){
		Ad ad = new Ad();
		ad.setServiceName(adDTO.getServiceName());
		ad.setDescription(adDTO.getDescription());
		ad.setImg(adDTO.getImg().getBytes());
		ad.setPrice(adDTO.getPrice());
		ad.setUser(optionalUser.get());
		adRepository.save(ad);
		return true;
		}
		return false;
		}
	
}
