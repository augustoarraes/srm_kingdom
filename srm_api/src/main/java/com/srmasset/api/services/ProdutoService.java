package com.srmasset.api.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.srmasset.api.models.ProdutoModel;
import com.srmasset.api.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	
	final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional
	public ProdutoModel save(ProdutoModel produtoModel) {
		return produtoRepository.save(produtoModel);
	}

	public Optional<ProdutoModel> findByid(long id){
		return produtoRepository.findById(id);
	}
}
