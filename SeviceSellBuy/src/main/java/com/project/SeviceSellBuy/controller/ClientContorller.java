package com.project.SeviceSellBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.SeviceSellBuy.dto.ReservationDTO;
import com.project.SeviceSellBuy.service.client.ClientServie;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/client")
public class ClientContorller {

	@Autowired
	private ClientServie clientServie;

	@GetMapping("/ads")
	public ResponseEntity<?> getAllAds(@RequestParam(required = false) String param) {
		return ResponseEntity.ok(clientServie.getAllAds());
	}

	@GetMapping("/search/{name}")
	public ResponseEntity<?> searchAdByService(@PathVariable String name) {
		return ResponseEntity.ok(clientServie.searchAdByName(name));
	}

	@PostMapping("/book-service")
	public ResponseEntity<?> bookService(@RequestBody ReservationDTO reservationDTO) {

		boolean success = clientServie.bookService(reservationDTO);
		if (success) {
			System.out.println("Received Book Date: " + reservationDTO.getBookDate());
			System.out.println("Received Book Date: " + reservationDTO.getReservationStatus());
			return ResponseEntity.status(HttpStatus.OK).build();

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/ad/{adId}")
	public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long adId) {
		return ResponseEntity.ok(clientServie.getAdDetailsByAdId(adId));
	}

	@GetMapping("/my-bookings/{userId}")
	public ResponseEntity<?> getAllBookingsByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(clientServie.getAllBookingsByUserId(userId));
	}

}
