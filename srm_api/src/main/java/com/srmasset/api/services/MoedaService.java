package com.srmasset.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.srmasset.api.models.MoedaModel;
import com.srmasset.api.repositories.MoedaRepository;

@Service
public class MoedaService {
	
	final MoedaRepository moedaRepository;

	public MoedaService(MoedaRepository moedaRepository) {
		this.moedaRepository = moedaRepository;
	}
	
	public Optional<MoedaModel> findByid(long id){
		return moedaRepository.findById(id);
	}
	
	@Transactional
	public MoedaModel save(MoedaModel moedaModel) {
		return moedaRepository.save(moedaModel);
	}
	
	public List<MoedaModel> findAll() {
		return moedaRepository.findAll();
	}

}
