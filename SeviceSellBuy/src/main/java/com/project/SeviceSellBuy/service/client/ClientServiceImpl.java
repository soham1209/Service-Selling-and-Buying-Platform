package com.project.SeviceSellBuy.service.client;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.model.Ad;
import com.project.SeviceSellBuy.repository.AdRepository;

@Service
public class ClientServiceImpl implements ClientServie{

	@Autowired
	private AdRepository adRepository;
	
	public List<AdDTO> getAllAds() {
		return adRepository.findAll().stream().map(Ad::getAdDTO).collect(Collectors.toList());
	}
	
	public List<AdDTO> searchAdByName(String name) {
		return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDTO).collect(Collectors.toList());
	}
}
