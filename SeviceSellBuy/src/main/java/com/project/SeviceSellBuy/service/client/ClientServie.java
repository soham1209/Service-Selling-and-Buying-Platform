package com.project.SeviceSellBuy.service.client;

import java.util.List;

import com.project.SeviceSellBuy.dto.AdDTO;

public interface ClientServie {

	public List<AdDTO> getAllAds();
	
	public List<AdDTO> searchAdByName(String name);
}
