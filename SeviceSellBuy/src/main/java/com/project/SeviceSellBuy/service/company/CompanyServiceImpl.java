package com.project.SeviceSellBuy.service.company;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.model.Ad;
import com.project.SeviceSellBuy.model.User;
import com.project.SeviceSellBuy.repository.AdRepository;
import com.project.SeviceSellBuy.repository.UserRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdRepository adRepository;

	public boolean postAd(Long userId, AdDTO adDTO) throws IOException {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
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

	public List<AdDTO> getAllAds(Long userId) {
		return adRepository.findAllByUserId(userId).stream().map(Ad::getAdDTO).collect(Collectors.toList());
	}

	public AdDTO getAdById(Long adId) {
		Optional<Ad> optionalAd = adRepository.findById(adId);
		if (optionalAd.isPresent()) {
			return optionalAd.get().getAdDTO();
		}
		return null;
	}

	public boolean updateAd(Long adId, AdDTO adDTO) throws IOException {
		Optional<Ad> optionalAd = adRepository.findById(adId);
		if (optionalAd.isPresent()) {
			Ad ad = optionalAd.get();
			ad.setServiceName(adDTO.getServiceName());
			ad.setDescription(adDTO.getDescription());
			ad.setPrice(adDTO.getPrice());
			if (adDTO.getImg() != null) {
				ad.setImg(adDTO.getImg().getBytes());
			}
			adRepository.save(ad);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteAd(Long adId) {
		Optional<Ad> optionalAd = adRepository.findById(adId);
		if (optionalAd.isPresent()) {
			adRepository.delete(optionalAd.get());
			return true;
		}
		return false;
	}

}
