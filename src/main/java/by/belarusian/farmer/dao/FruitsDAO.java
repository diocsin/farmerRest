package by.belarusian.farmer.dao;

import by.belarusian.farmer.enums.HarvestType;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.pattern.abstractfactory.HarvestFactoryProvider;
import by.belarusian.farmer.pattern.abstractfactory.IHarvestFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FruitsDAO implements HarvestDao {
    private final static IHarvestFactory harvestFactory = HarvestFactoryProvider.getFactory(HarvestType.FRUITS);

    public final static List<Harvest> fruits = harvestFactory.of(AMOUNT_HARVESTS);

    @Override
    public List<Harvest> getAll() {
        return fruits;
    }

    @Override
    public Optional<Harvest> create(String name) {
        return Optional.of(harvestFactory.create(name));
    }
}
