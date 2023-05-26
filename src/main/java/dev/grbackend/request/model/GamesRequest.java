package dev.grbackend.request.model;

import dev.grbackend.models.Game;
import dev.grbackend.response.model.GamesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GamesRequest {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Game> httpEntity = new HttpEntity<Game>(headers);
    @Value("${rawg.host}") private String host;
    @Value("${rawg.api-key}") private String apiKey;
    @Value("${games.endpoint}") private String endpoint;
    @Value("${pageNumber.queryParam}") private String queryParam;
    private final Integer numGamePages = 10;

    public List<Game> getGames(){
        List<Game> result = new ArrayList<>();
        GamesResponse games = null;

        ResponseEntity<GamesResponse> getGamesResponse = null;
        for(Integer i = 1; i <= numGamePages; i++ ){
            getGamesResponse = doRequest(i);
            games =getGamesResponse.getBody();
            result.addAll(Objects.requireNonNull(games).getResults());
        }
        return result;
    }

    public ResponseEntity<GamesResponse> doRequest(Integer page){
        String uri = host+endpoint+"?key="+apiKey+"&"+queryParam+"="+page;
        return restTemplate.exchange(uri, HttpMethod.GET,httpEntity,GamesResponse.class);
    }


}
