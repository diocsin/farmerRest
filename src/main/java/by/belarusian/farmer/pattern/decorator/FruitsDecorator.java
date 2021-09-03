package by.belarusian.farmer.pattern.decorator;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.pattern.abstractfactory.FruitsFactory;
import by.belarusian.farmer.pattern.abstractfactory.IHarvestFactory;
import by.belarusian.farmer.utils.PrintUtil;

import java.util.List;

public class FruitsDecorator implements IHarvestFactory {

    private final IHarvestFactory fruitsFactory;

    public FruitsDecorator(IHarvestFactory fruitsFactory) {
        this.fruitsFactory = fruitsFactory;
    }

    @Override
    public Harvest create(String name) {
        final Harvest harvest = fruitsFactory.create(name);
        PrintUtil.print("Create " + harvest);
        return harvest;
    }

    @Override
    public List<Harvest> of(int amount) {
        final List<Harvest> harvests = fruitsFactory.of(amount);
        PrintUtil.print("Create " + amount + " harvests: " + harvests);
        return harvests;
    }
}
