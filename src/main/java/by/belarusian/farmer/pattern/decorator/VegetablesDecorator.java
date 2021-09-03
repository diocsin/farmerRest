package by.belarusian.farmer.pattern.decorator;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.pattern.abstractfactory.IHarvestFactory;
import by.belarusian.farmer.pattern.abstractfactory.VegetablesFactory;
import by.belarusian.farmer.utils.PrintUtil;

import java.util.List;

public class VegetablesDecorator implements IHarvestFactory {

    private final IHarvestFactory vegetablesFactory;

    public VegetablesDecorator(IHarvestFactory berriesFactory) {
        this.vegetablesFactory = berriesFactory;
    }

    @Override
    public Harvest create(String name) {
        final Harvest harvest = vegetablesFactory.create(name);
        PrintUtil.print("Create " + harvest);
        return harvest;
    }

    @Override
    public List<Harvest> of(int amount) {
        final List<Harvest> harvests = vegetablesFactory.of(amount);
        PrintUtil.print("Create " + amount + " harvests: " + harvests);
        return harvests;
    }
}
