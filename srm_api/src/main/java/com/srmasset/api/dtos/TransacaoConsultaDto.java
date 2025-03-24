package com.srmasset.api.dtos;

import java.time.LocalDateTime;

public class TransacaoConsultaDto {
	private String protocolo;
	private String produto;
	private String moedaOrigem;
	private String moedaDestino;
	private String reino;
	private double valorTaxaCambio;
	private double valorFinal;
	private LocalDateTime data;

	public TransacaoConsultaDto(String protocolo, String produto, String moedaOrigem, String moedaDestino, String reino,
			double valorTaxaCambio, double valorFinal, LocalDateTime data) {
		this.protocolo = protocolo;
		this.produto = produto;
		this.moedaOrigem = moedaOrigem;
		this.moedaDestino = moedaDestino;
		this.reino = reino;
		this.valorTaxaCambio = valorTaxaCambio;
		this.valorFinal = valorFinal;
		this.data = data;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getMoedaOrigem() {
		return moedaOrigem;
	}

	public void setMoedaOrigem(String moedaOrigem) {
		this.moedaOrigem = moedaOrigem;
	}

	public String getMoedaDestino() {
		return moedaDestino;
	}

	public void setMoedaDestino(String moedaDestino) {
		this.moedaDestino = moedaDestino;
	}

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public double getValorTaxaCambio() {
		return valorTaxaCambio;
	}

	public void setValorTaxaCambio(double valorTaxaCambio) {
		this.valorTaxaCambio = valorTaxaCambio;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
