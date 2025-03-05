package org.example.services;
import org.example.models.Pokemon;
import org.example.models.Results;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.*;
import java.util.List;

public class PokemonService {
    private RestTemplate restTemplate = new RestTemplate();
    private final String API_URL="https://pokeapi.co/api/v2/pokemon/";
    public List<Pokemon> getPokemon(){
        Results rs = restTemplate.getForObject(API_URL, Results.class);
        return rs.getResults();
    }


}
