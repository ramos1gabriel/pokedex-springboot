package com.pokedex.springboot.model;

import java.util.ArrayList;

public class PokemonDTO {

	private int order;
	private String nome;
	private ArrayList<String> types;
	private String imagemUrl;
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<String> getTypes() {
		return types;
	}
	
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	
	public String getImagemUrl() {
		return imagemUrl;
	}
	
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
}
