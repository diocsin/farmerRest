package by.belarusian.farmer.service;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Banana;

import java.util.Optional;

public interface FruitsService extends HarvestsService {

    Harvest saveBanana(Banana banana);

    Optional<Harvest> createFruit(String name);

}
