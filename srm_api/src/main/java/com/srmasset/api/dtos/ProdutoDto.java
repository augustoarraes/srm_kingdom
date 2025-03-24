package com.srmasset.api.dtos;

public class ProdutoDto {

	private String nome;
	private double valor;
	private long idMoedaRef;
	private String reino;
	private double taxaEspecifica;
	
	public ProdutoDto(String nome, double valor, long idMoedaRef, String reino, double taxaEspecifica) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.idMoedaRef = idMoedaRef;
		this.reino = reino;
		this.taxaEspecifica = taxaEspecifica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getIdMoedaRef() {
		return idMoedaRef;
	}

	public void setIdMoedaRef(long idMoedaRef) {
		this.idMoedaRef = idMoedaRef;
	}

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public double getTaxaEspecifica() {
		return taxaEspecifica;
	}

	public void setTaxaEspecifica(double taxaEspecifica) {
		this.taxaEspecifica = taxaEspecifica;
	}
	
}
