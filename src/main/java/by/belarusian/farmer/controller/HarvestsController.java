package by.belarusian.farmer.controller;

import by.belarusian.farmer.exception.HarvestNotFoundException;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.service.HarvestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/harvests")
public class HarvestsController {

    private final HarvestsService service;

    @Autowired
    public HarvestsController(@Qualifier("harvestsServiceImpl") HarvestsService service) {
        this.service = service;
    }

    @GetMapping("/findAllHarvests")
    public ResponseEntity<?> findAllHarvests() {
        try {
            final List<Harvest> harvests = service.getAllHarvests();
            System.out.printf("GET /findAllHarvests return %d objects", harvests.size());
            return ResponseEntity.ok(harvests);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching data", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getHarvest")
    public ResponseEntity<?> getHarvestById(
            @RequestParam(value = "id", defaultValue = "1") final Long id) {
        final Optional<Harvest> harvest = service.getHarvestById(id);
        return harvest.map(ResponseEntity::ok).orElseThrow(HarvestNotFoundException::new);
    }


    @GetMapping("/getHarvestsPagination")
    public ResponseEntity<?> getHarvestPagination(
            @RequestParam(value = "offset", defaultValue = "0") final int offset,
            @RequestParam(value = "limit", defaultValue = "100") final int limit,
            @RequestParam(value = "filterColor", required = false) final String filter) {
        try {
            final List<Harvest> harvests = service.findHarvests(offset, limit, filter);
            System.out.println(
                    String.format("GET /getHarvestsPagination: params:[offset - %d, limit - %d, filterColor - %s], return %d objects",
                            offset, limit, filter, harvests.size()));
            return ResponseEntity.ok(harvests);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching data", HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
