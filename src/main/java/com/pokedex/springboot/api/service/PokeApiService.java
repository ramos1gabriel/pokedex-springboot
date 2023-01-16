package com.pokedex.springboot.api.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pokedex.springboot.api.model.Pokemon;
import com.pokedex.springboot.api.model.PokemonDetail;
import com.pokedex.springboot.api.model.Result;
import com.pokedex.springboot.api.model.Type;
import com.pokedex.springboot.api.service.impl.PokeApiServiceImpl;
import com.pokedex.springboot.constants.Constantes;
import com.pokedex.springboot.model.PokemonDTO;

@Service
public class PokeApiService implements PokeApiServiceImpl {
	
	private static final Logger log = LogManager.getLogger(PokeApiService.class);
	
	public Pokemon listarPokemonUrl(String offset, String limit) throws Exception {
		
		String url = Constantes.URL_POKEMON;
		url = url.replace("@", offset);
		url = url.replace("$", limit);
		
		Pokemon obj = new Pokemon();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		
		try {
			HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			obj = new Gson().fromJson(response.body(), Pokemon.class);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			log.error(e);
		}
		
		return obj;
	}
	
	public PokemonDetail listarPokemonDetail(String url) throws Exception {
		
		PokemonDetail obj = new PokemonDetail();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		
		try {
			HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());		
			obj = new Gson().fromJson(response.body(), PokemonDetail.class);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			log.error(e);
		}
		
		return obj;
	}
	
	public ArrayList<PokemonDTO> listarPokemon(String offset, String limit) throws Exception {
		
		ArrayList<PokemonDTO> listDTO = new ArrayList<PokemonDTO>();
		
		//pega url
		Pokemon obj = listarPokemonUrl(offset, limit);
		
		//para cada url pega detail
		for (Result result : obj.getResults()) {
			
			PokemonDTO dto = new PokemonDTO();
			
			ArrayList<String> tipos = new ArrayList<String>();
			PokemonDetail detail = listarPokemonDetail(result.getUrl());
			
			dto.setOrder(detail.getOrder());
			dto.setNome(detail.getName());
			//System.out.println("#"+detail.getOrder());
			//System.out.println(detail.getName());
			for (Type type : detail.getTypes()) {
				tipos.add(type.getType().getName());
				//System.out.println(type.getType().getName());
			}
			dto.setTypes(tipos);
			dto.setImagemUrl(detail.getSprites().getOther().getOfficialArtwork().getFrontDefault());
			
			listDTO.add(dto);
		}
		
		return listDTO;
	}
}
