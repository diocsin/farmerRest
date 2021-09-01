package by.belarusian.farmer.pattern.abstractfactory;

import by.belarusian.farmer.model.Harvest;

import java.util.List;

public interface IHarvestFactory {

    Harvest create(final String name);

    List<Harvest> of(final int amount);
}
