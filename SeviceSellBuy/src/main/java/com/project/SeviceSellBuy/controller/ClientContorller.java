package com.project.SeviceSellBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.SeviceSellBuy.service.client.ClientServie;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/client")
public class ClientContorller {
	
	@Autowired
	private ClientServie clientServie;
	
	@GetMapping("/ads")
	public ResponseEntity<?> getAllAds(@RequestParam(required = false) String param) {
		return 	ResponseEntity.ok(clientServie.getAllAds());
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<?> searchAdByService(@PathVariable String name){
		return ResponseEntity.ok(clientServie.searchAdByName(name));
	}
	
}
