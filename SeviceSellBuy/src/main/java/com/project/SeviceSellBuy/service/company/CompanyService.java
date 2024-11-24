package com.project.SeviceSellBuy.service.company;

import java.io.IOException;
import java.util.List;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.dto.ReservationDTO;

public interface CompanyService {

	public boolean postAd(Long userId, AdDTO adDTO) throws IOException ;
	
	public List<AdDTO> 	getAllAds(Long userId);
	
	public AdDTO getAdById(Long adId);
	
	public boolean updateAd(Long adId, AdDTO adDTO) throws IOException;
	
	public boolean deleteAd(Long adId);
	
	public List<ReservationDTO> getAllAdBookings (Long companyId);
	
	public boolean changeBookingStatus (Long bookingId, String status);
}
