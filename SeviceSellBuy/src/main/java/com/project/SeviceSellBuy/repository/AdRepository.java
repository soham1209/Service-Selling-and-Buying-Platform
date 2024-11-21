package com.project.SeviceSellBuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SeviceSellBuy.model.Ad;
import com.project.SeviceSellBuy.dto.AdDTO;


@Repository
public interface AdRepository extends JpaRepository<Ad, Long>{
	
	List<Ad> findAllByUserId(Long userId);
}
