package com.example.demo.resources;

import com.example.demo.entity.Country;
import com.example.demo.entity.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/board")
public class Football {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String BASE_URL = "https://apifootball.com/documentation/";

    @GetMapping("/countries")
    public List<Country> getCountries() {
        Mono<List<Country>> response = webClientBuilder.build().get()
                .uri(uriBuilder -> uriBuilder.path(BASE_URL)
                .queryParam("APIKey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
                .queryParam("action","get_countries")
                .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Country>>() {});

        return response.block();
    }

    @GetMapping("/leagues")
    public List<League> getLeagues(@RequestParam(name = "country_id") String countryId) {
        Mono<List<League>> response = webClientBuilder.build().get()
                .uri(uriBuilder -> uriBuilder.path(BASE_URL)
                        .queryParam("APIKey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
                        .queryParam("action","get_leagues")
                        .queryParam("country_id",countryId)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<League>>() {});

        return response.block();
    }

    @GetMapping("/team")
    public List<League> getTeams(@RequestParam(required = false, name = "team_id") String teamId,
                                 @RequestParam(required = false, name = "league_id") String leagueId) {
        Mono<List<League>> response = webClientBuilder.build().get()
                .uri(uriBuilder -> uriBuilder.path(BASE_URL)
                        .queryParam("APIKey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
                        .queryParam("action","get_teams")
                        .queryParam("team_id",teamId)
                        .queryParam("league_id",leagueId)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<League>>() {});

        return response.block();
    }

}
