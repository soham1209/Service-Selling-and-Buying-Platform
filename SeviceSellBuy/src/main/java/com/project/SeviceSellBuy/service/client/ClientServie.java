package com.project.SeviceSellBuy.service.client;

import java.util.List;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.dto.AdDetailsForClientDto;
import com.project.SeviceSellBuy.dto.ReservationDTO;

public interface ClientServie {

	public List<AdDTO> getAllAds();
	
	public List<AdDTO> searchAdByName(String name);
	
	public boolean bookService(ReservationDTO reservationDTO);
	
	public AdDetailsForClientDto getAdDetailsByAdId(Long adId);
}
