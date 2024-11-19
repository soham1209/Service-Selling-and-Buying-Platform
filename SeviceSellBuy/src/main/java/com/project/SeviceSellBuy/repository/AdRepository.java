package com.project.SeviceSellBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SeviceSellBuy.model.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long>{

}
