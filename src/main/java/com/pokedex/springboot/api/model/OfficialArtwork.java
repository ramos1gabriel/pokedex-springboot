package com.pokedex.springboot.api.model;

import com.google.gson.annotations.SerializedName;

public class OfficialArtwork{
	
	@SerializedName("front_default")
	public String frontDefault;
	
	public String getFrontDefault() {
		return frontDefault;
	}
	
	public void setFrontDefault(String frontDefault) {
		this.frontDefault = frontDefault;
	}
}
