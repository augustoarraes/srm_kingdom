package com.srmasset.api.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.srmasset.api.models.TaxaCambioModel;

public class TaxaCambioDto {
	
	private long id;

	@NotBlank
	private double valorTaxa;
	
	private LocalDateTime data;
	
	private long idMoedaOrigem;
	private String nomeMoedaOrigem;
	
	private long idMoedaDestino;
	private String nomeMoedaDestino;
	
	public TaxaCambioDto(TaxaCambioModel taxaCambio) {
		this.id = taxaCambio.getId();
        this.valorTaxa = taxaCambio.getValorTaxa();
        this.data = taxaCambio.getData();
        this.idMoedaOrigem = taxaCambio.getMoedaOrigem().getId();
        this.nomeMoedaOrigem = taxaCambio.getMoedaOrigem().getNome();
        this.idMoedaDestino = taxaCambio.getMoedaDestino().getId();
        this.nomeMoedaDestino = taxaCambio.getMoedaDestino().getNome();
    }
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeMoedaOrigem() {
		return nomeMoedaOrigem;
	}

	public void setNomeMoedaOrigem(String nomeMoedaOrigem) {
		this.nomeMoedaOrigem = nomeMoedaOrigem;
	}

	public double getValorTaxa() {
		return valorTaxa;
	}
	
	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public long getIdMoedaOrigem() {
		return idMoedaOrigem;
	}

	public void setIdMoedaOrigem(long idMoedaOrigem) {
		this.idMoedaOrigem = idMoedaOrigem;
	}

	public long getIdMoedaDestino() {
		return idMoedaDestino;
	}

	public void setIdMoedaDestino(long idMoedaDestino) {
		this.idMoedaDestino = idMoedaDestino;
	}



	@Override
	public String toString() {
		return "TaxaCambioDto [id=" + id + ", valorTaxa=" + valorTaxa + ", data=" + data + ", idMoedaOrigem="
				+ idMoedaOrigem + ", nomeMoedaOrigem=" + nomeMoedaOrigem + ", idMoedaDestino=" + idMoedaDestino
				+ ", nomeMoedaDestino=" + nomeMoedaDestino + "]";
	}
	
	

}
