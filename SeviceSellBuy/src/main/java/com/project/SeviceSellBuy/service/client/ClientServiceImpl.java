package com.project.SeviceSellBuy.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.dto.AdDetailsForClientDto;
import com.project.SeviceSellBuy.dto.ReservationDTO;
import com.project.SeviceSellBuy.enums.ReservationStatus;
import com.project.SeviceSellBuy.enums.ReviewStatus;
import com.project.SeviceSellBuy.model.Ad;
import com.project.SeviceSellBuy.model.Reservation;
import com.project.SeviceSellBuy.model.User;
import com.project.SeviceSellBuy.repository.AdRepository;
import com.project.SeviceSellBuy.repository.ReservationRepository;
import com.project.SeviceSellBuy.repository.UserRepository;

@Service
public class ClientServiceImpl implements ClientServie {

	@Autowired
	private AdRepository adRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public List<AdDTO> getAllAds() {
		return adRepository.findAll().stream().map(Ad::getAdDTO).collect(Collectors.toList());
	}

	public List<AdDTO> searchAdByName(String name) {
		return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDTO)
				.collect(Collectors.toList());
	}

	public boolean bookService(ReservationDTO reservationDTO) {

		Optional<Ad> optionalAd = adRepository.findById(reservationDTO.getAdId());
		Optional<User> optionalUser = userRepository.findById(reservationDTO.getUserId());

		if (optionalAd.isPresent() && optionalUser.isPresent()) {
			Reservation reservation = new Reservation();
			reservation.setBookDate(reservationDTO.getBookDate());
			reservation.setReservationStatus(ReservationStatus.PENDING);
			reservation.setUser(optionalUser.get());
			reservation.setAd(optionalAd.get());
			reservation.setCompany(optionalAd.get().getUser());
			reservation.setReviewStatus(ReviewStatus.FALSE);
			reservationRepository.save(reservation);
			System.out.println(reservation.getBookDate());
			return true;
		}
		return false;
	}

	public AdDetailsForClientDto getAdDetailsByAdId(Long adId) {
		Optional<Ad> optionalAd = adRepository.findById(adId);
		AdDetailsForClientDto adDetailsForClientDTO = new AdDetailsForClientDto();
		if (optionalAd.isPresent()) {
			adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDTO());
		}
		return adDetailsForClientDTO;
	}
	
	public List<ReservationDTO> getAllBookingsByUserId(Long userId){
		return reservationRepository.findAllByUserId(userId)
				.stream().map(Reservation::getReservationDto).collect(Collectors.toList());
	}
}
