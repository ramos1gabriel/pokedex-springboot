package com.pokedex.springboot.api.model;

import java.util.ArrayList;

public class PokemonDetail {
//	public ArrayList<Ability> abilities;
//    public int base_experience;
//    public ArrayList<Form> forms;
//    public ArrayList<GameIndex> game_indices;
//    public int height;
//    public ArrayList<Object> held_items;
//    public int id;
//    public boolean is_default;
//    public String location_area_encounters;
//    public ArrayList<Move> moves;
	private String name;
    private int order;
//    public ArrayList<Object> past_types;
//    public Species species;
    private Sprites sprites;
//    public ArrayList<Stat> stats;
	private ArrayList<Type> types;
//    public int weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public ArrayList<Type> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<Type> types) {
		this.types = types;
	}
	
	public Sprites getSprites() {
		return sprites;
	}
	
	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
}
