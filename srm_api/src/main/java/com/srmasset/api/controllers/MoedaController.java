package com.srmasset.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmasset.api.models.MoedaModel;
import com.srmasset.api.services.MoedaService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/moeda")
public class MoedaController {
	
	final MoedaService moedaService;

	public MoedaController(MoedaService moedaService) {
		this.moedaService = moedaService;
	}
	
	@GetMapping
	public ResponseEntity<List<MoedaModel>> getTodasMoedas(){
		return ResponseEntity.status(HttpStatus.OK).body(moedaService.findAll());
	}
	
}