package com.srmasset.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.srmasset.api.dtos.TaxaCambioDto;
import com.srmasset.api.models.TaxaCambioModel;
import com.srmasset.api.repositories.TaxaCambioRepository;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TaxaCambioService {
	
	final TaxaCambioRepository taxacambioRepository;
	
	public TaxaCambioService(TaxaCambioRepository taxacambioRepository) {
		this.taxacambioRepository = taxacambioRepository;
	}
	
	@Transactional
	public TaxaCambioModel save(TaxaCambioModel taxacambioModel) {
		return taxacambioRepository.save(taxacambioModel);
	}

	public List<TaxaCambioDto> findAll() {
		List<TaxaCambioModel> taxaList = taxacambioRepository.findAll();
		return taxaList.stream().map(TaxaCambioDto::new).collect(Collectors.toList());
	}

	public Optional<TaxaCambioModel> findByid(long id) {
		return taxacambioRepository.findById(id);
	}
	
	public List<TaxaCambioDto> findByIdMoedaOrigemOrIdMoedaDestino(long idMoedaOrigem, long idMoedaDestino){
		List<TaxaCambioModel> taxaCambioList = taxacambioRepository.findByIdMoedaOrigemOrIdMoedaDestino(idMoedaOrigem, idMoedaDestino);
		return taxaCambioList.stream()
	            .map(TaxaCambioDto::new) // Converte cada modelo para DTO
	            .collect(Collectors.toList());
	}
	
	public TaxaCambioModel findByIdMoedaOrigemAndIdMoedaDestino(long idMoedaOrigem, long idMoedaDestino){
		return taxacambioRepository.findByIdMoedaOrigemAndIdMoedaDestino(idMoedaOrigem, idMoedaDestino);
	}

}
