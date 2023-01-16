package com.pokedex.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pokedex.springboot.api.service.PokeApiService;
import com.pokedex.springboot.model.PokemonDTO;

@RestController
class PokedexController {
	
	private static final Logger log = LogManager.getLogger(PokedexController.class);
	
	/**
	 * POKE-API
	 * https://pokeapi.co/docs/v2
	 **/
	
	//carregar inicial backend (?)
	//tamanho botao
	//separar por geracao (?)

	@Autowired
	PokeApiService pokeService;
	
	private ArrayList<PokemonDTO> pokemons = null;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("index");
		String limit = "6"; 
		
		try {
			pokemons = new ArrayList<PokemonDTO>();
			setPokemons(pokeService.listarPokemon("0", limit));
			mv.addObject("pokemons", getPokemons());
			
		} catch (Exception e) {
			log.error("erro home", e);
		}
		
		return mv;
	}
	
	//AJAX
	@PostMapping("/carregarPokemonsAjax")
    public ResponseEntity<List<PokemonDTO>> carregarPokemonsAjax(@RequestParam("offset") String offset) {
		
		try {
			this.pokemons.addAll(pokeService.listarPokemon(offset, "6"));
		} catch (Exception e) {
            log.error("erro carregarPokemonsAjax:", e);
		}
        
        return new ResponseEntity<List<PokemonDTO>>(getPokemons(), HttpStatus.OK);
    }
	
	//
	public ArrayList<PokemonDTO> getPokemons() {
		return pokemons;
	}
	
	public void setPokemons(ArrayList<PokemonDTO> pokemons) {
		this.pokemons = pokemons;
	}
}