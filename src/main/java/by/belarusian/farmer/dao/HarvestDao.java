package by.belarusian.farmer.dao;

import by.belarusian.farmer.model.Harvest;

import java.util.List;
import java.util.Optional;

public interface HarvestDao {

    int AMOUNT_HARVESTS = 1000;

    List<Harvest> getAll();

    Optional<Harvest> create(String name);
}
