package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrelloClient {
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndPoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloAppToken;
    @Value("${trello.app.username}")
    private String trelloAppUsername;

    private final RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards() {
        URI url = buildTrelloBoardsUrl();

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

       return Optional.ofNullable(boardsResponse)
               .map(Arrays::asList)
               .orElse(Collections.emptyList());
    }

    private URI buildTrelloBoardsUrl(){
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndPoint + "/members/" +trelloAppUsername +"/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloAppToken)
                .queryParam("fields","name,id")
                .build()
                .encode()
                .toUri();
        return url;
    };
}


