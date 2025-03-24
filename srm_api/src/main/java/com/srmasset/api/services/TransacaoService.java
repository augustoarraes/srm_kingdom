package com.srmasset.api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.srmasset.api.dtos.ConversaoResponseDto;
import com.srmasset.api.models.MoedaModel;
import com.srmasset.api.models.ProdutoModel;
import com.srmasset.api.models.TaxaCambioModel;
import com.srmasset.api.models.TransacaoModel;
import com.srmasset.api.repositories.MoedaRepository;
import com.srmasset.api.repositories.ProdutoRepository;
import com.srmasset.api.repositories.TaxaCambioRepository;
import com.srmasset.api.repositories.TransacaoRepository;


@Service
public class TransacaoService {
	
	final TaxaCambioRepository taxacambioRepository;
	final ProdutoRepository produtoRepository;
    final TransacaoRepository transacaoRepository;
    final MoedaRepository moedaRepository;
	
	public TransacaoService(TaxaCambioRepository taxacambioRepository,
							ProdutoRepository produtoRepository,
							TransacaoRepository transacaoRepository,
							MoedaRepository moedaRepository) {
		this.taxacambioRepository = taxacambioRepository;
		this.produtoRepository = produtoRepository;
		this.transacaoRepository = transacaoRepository;
		this.moedaRepository = moedaRepository;
	}
	
	
	public ConversaoResponseDto converterMoeda(long idProduto, long idMoedaDestino, double quantidade, String uuid) {
        // aqui busca o produto e sua moeda de origem
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(idProduto);
        if (!produtoOptional.isPresent()) {
            throw new RuntimeException("Produto não encontrado");
        }
        ProdutoModel produto = produtoOptional.get();
        long idMoedaOrigem = produto.getIdMoedaRef();

        // depois busca a taxa de cambio correspondente a partir da Moeda de Origem encontrada para a Moeda Desejada (destino)
        TaxaCambioModel taxaOptional = taxacambioRepository.findByIdMoedaOrigemAndIdMoedaDestino(idMoedaOrigem, idMoedaDestino);
        double taxaCambio = taxaOptional.getValorTaxa();

        // calcula a conversão
        double valorConvertido = quantidade * taxaCambio * produto.getTaxaEspecifica();
        
        // melhora o DTO de resposta
        Optional<MoedaModel> moedaOrigem = moedaRepository.findById(idMoedaOrigem);
        Optional<MoedaModel> moedaDestino = moedaRepository.findById(idMoedaDestino);

        // registra a transação no banco
        TransacaoModel transacao = new TransacaoModel();
        transacao.setIdProduto(idProduto);
        transacao.setIdMoedaOrigem(idMoedaOrigem);
        transacao.setIdMoedaDestino(idMoedaDestino);
        transacao.setValorFinal(valorConvertido);
        transacao.setReino(moedaDestino.get().getReino());
        LocalDateTime transacao_hora = LocalDateTime.now();
        transacao.setData(transacao_hora);
        transacao.setProtocolo(uuid);
        transacaoRepository.save(transacao);

        return new ConversaoResponseDto(
                produto.getNome(),
                moedaOrigem.get().getNome(),
                moedaDestino.get().getNome(),
                taxaCambio,
                quantidade,
                valorConvertido,
                transacao_hora
        );
    }
	
	public List<TransacaoModel> findAll() {
		return transacaoRepository.findAll();
	}


	public Optional<TransacaoModel> findByProtocolo(String protocolo) {
		return transacaoRepository.findByProtocolo(protocolo);
	}
	
	

}
