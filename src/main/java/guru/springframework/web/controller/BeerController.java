package guru.springframework.web.controller;

import guru.springframework.service.BeerService;
import guru.springframework.web.model.BeerDto;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId)
    {
    System.out.println("BeerAPI");
     //   return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK); comment
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto)
    {
        BeerDto savedDto = beerService.save(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer"+savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity handlePut(@PathVariable("beerId")UUID beerId, BeerDto beerDto)
    {
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
