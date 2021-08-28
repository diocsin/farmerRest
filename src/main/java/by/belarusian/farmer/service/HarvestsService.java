package by.belarusian.farmer.service;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Banana;

import java.util.List;
import java.util.Optional;

public interface HarvestsService {

    List<Harvest> getAllHarvests();

    Optional<Harvest> getHarvestById(Long id);

    List<Harvest> findHarvests(int offset, int limit, String filterColor);

    Harvest saveBanana(Banana banana);
}
