package org.example.services;
import org.example.models.Pokemon;
import org.example.models.PokemonDetail;
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

    public List<Pokemon> getMorePokemon(int startVal){
        //"https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20"
        Results rs = restTemplate.getForObject(API_URL + "?offset=" + startVal + "&limit=20", Results.class);
        List<Pokemon> list = rs.getResults();
        for (Pokemon item: list){
            String url = item.getUrl();
            int pokemonIndex = url.indexOf("pokemon");
            String pokemonString = url.substring(pokemonIndex);
            int slashIndex = pokemonString.indexOf("/");
            String number = pokemonString.substring(slashIndex + 1, pokemonString.length()-1);
            int id = Integer.parseInt(number);
            item.setId(id);
        }
        return list;
    }

    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail pokemonDetail = restTemplate.getForObject(API_URL + "/" + id, PokemonDetail.class);

        return pokemonDetail;
    }


}
