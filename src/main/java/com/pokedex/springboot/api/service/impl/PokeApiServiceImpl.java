package com.pokedex.springboot.api.service.impl;

import java.util.ArrayList;

import com.pokedex.springboot.api.model.Pokemon;
import com.pokedex.springboot.api.model.PokemonDetail;
import com.pokedex.springboot.model.PokemonDTO;

public interface PokeApiServiceImpl {
	public Pokemon listarPokemonUrl(String offset, String limit) throws Exception;
	public PokemonDetail listarPokemonDetail(String url) throws Exception;
	public ArrayList<PokemonDTO> listarPokemon(String offset, String limit) throws Exception;
}
