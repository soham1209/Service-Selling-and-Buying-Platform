package com.project.SeviceSellBuy.service.company;

import java.io.IOException;

import com.project.SeviceSellBuy.dto.AdDTO;

public interface CompanyService {

	public boolean postAd (Long userId, AdDTO adDTO) throws IOException ;
}
