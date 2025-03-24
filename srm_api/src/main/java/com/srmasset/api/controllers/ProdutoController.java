package com.srmasset.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.srmasset.api.models.ProdutoModel;
import com.srmasset.api.services.ProdutoService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/produto")
public class ProdutoController {
	
	final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProdutoTaxaEspecifica(@PathVariable(value="id") Long id, @RequestParam double novataxa){
		Optional<ProdutoModel> produtoModelOptional = produtoService.findByid(id);
		if (!produtoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
		}
		produtoModelOptional.get().setTaxaEspecifica(novataxa);
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModelOptional.get()));
	}
	

}
