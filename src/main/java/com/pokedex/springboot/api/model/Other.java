package com.pokedex.springboot.api.model;

import com.google.gson.annotations.SerializedName;

public class Other{
//	public DreamWorld dream_world;
//  public Home home;
	
	@SerializedName("official-artwork")
    private OfficialArtwork officialArtwork;
    
    public OfficialArtwork getOfficialArtwork() {
		return officialArtwork;
	}
    
    public void setOfficialArtwork(OfficialArtwork officialArtwork) {
		this.officialArtwork = officialArtwork;
	}
}
