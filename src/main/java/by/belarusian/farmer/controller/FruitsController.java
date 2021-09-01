package by.belarusian.farmer.controller;

import by.belarusian.farmer.exception.HarvestNotFoundException;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Banana;
import by.belarusian.farmer.service.FruitsService;
import by.belarusian.farmer.service.HarvestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitsController {

    private final FruitsService service;

    @Autowired
    public FruitsController(FruitsService service) {
        this.service = service;
    }

    @PostMapping("/createFruit")
    public ResponseEntity<?> createFruit(@RequestBody final String name) {
        Optional<Harvest> fruit = service.createFruit(name);
        return fruit.map(ResponseEntity::ok).orElseThrow(HarvestNotFoundException::new);
    }

    @PostMapping("/saveBanana")
    public ResponseEntity<?> saveBanana(@RequestBody Banana banana) {
        try {
            final Harvest harvest = service.saveBanana(banana);
            System.out.println("Добавлен банан");
            URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/getHarvest")
                    .queryParam("id", banana.getId()).build().toUri();
            return ResponseEntity.created(uri).body(harvest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not save", e);
        }
    }
}
