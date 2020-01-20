package guru.springframework.service;

import guru.springframework.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto save(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);
}
