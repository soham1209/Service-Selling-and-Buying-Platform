package com.project.SeviceSellBuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SeviceSellBuy.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findAllByCompanyId(Long companyId);
	
	List<Reservation> findAllByUserId(Long userId);
	
}
