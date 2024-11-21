package com.project.SeviceSellBuy.service.company;

import java.io.IOException;
import java.util.List;

import com.project.SeviceSellBuy.dto.AdDTO;

public interface CompanyService {

	public boolean postAd(Long userId, AdDTO adDTO) throws IOException ;
	
	public List<AdDTO> 	getAllAds(Long userId);
}
