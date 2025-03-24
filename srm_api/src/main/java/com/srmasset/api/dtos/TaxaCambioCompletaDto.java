package com.srmasset.api.dtos;

import org.springframework.beans.BeanUtils;

import com.srmasset.api.models.TaxaCambioModel;

public class TaxaCambioCompletaDto {
	
	private TaxaCambioDto moedaOrigem;
	private TaxaCambioDto moedaDestino;
	
	public TaxaCambioCompletaDto(TaxaCambioModel moedaOrigemModel, TaxaCambioModel moedaDestinoModel) {
		this.moedaOrigem = new TaxaCambioDto(moedaOrigemModel);
		this.moedaDestino = new TaxaCambioDto(moedaDestinoModel);
	}

	public TaxaCambioDto getMoedaOrigem() {
		return moedaOrigem;
	}

	public void setMoedaOrigem(TaxaCambioDto moedaOrigem) {
		this.moedaOrigem = moedaOrigem;
	}

	public TaxaCambioDto getMoedaDestino() {
		return moedaDestino;
	}

	public void setMoedaDestino(TaxaCambioDto moedaDestino) {
		this.moedaDestino = moedaDestino;
	}

}
