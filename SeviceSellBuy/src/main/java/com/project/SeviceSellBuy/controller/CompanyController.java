package com.project.SeviceSellBuy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.SeviceSellBuy.dto.AdDTO;
import com.project.SeviceSellBuy.service.company.CompanyService;

@RequestMapping("/api/company")
@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/ad/{userId}")
	public ResponseEntity<?> postAd(@PathVariable Long userId, @ModelAttribute AdDTO adDTO) throws IOException {
	 	System.out.println("Applying CORS configuration for allowed origins: http://localhost:4200");
		boolean success = companyService.postAd(userId, adDTO);
		if (success) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/ads/{userId}")
	public ResponseEntity<?> getAllAdsByUserId(@PathVariable Long userId) {
	return ResponseEntity.ok(companyService.getAllAds(userId));
	}
}
