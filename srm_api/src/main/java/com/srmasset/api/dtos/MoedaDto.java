package com.srmasset.api.dtos;

import com.srmasset.api.models.MoedaModel;

public class MoedaDto {
	
	private long id;
	
	private String nome;
	
	private String codigo;
	
	private String reino;
	
	

	public MoedaDto(MoedaModel moeda) {
		this.id = moeda.getId();
		this.nome = moeda.getNome();
		this.codigo = moeda.getCodigo();
		this.reino = moeda.getReino();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}
	
	

}
