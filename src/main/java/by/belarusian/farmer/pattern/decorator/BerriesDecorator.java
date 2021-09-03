package by.belarusian.farmer.pattern.decorator;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.pattern.abstractfactory.BerriesFactory;
import by.belarusian.farmer.pattern.abstractfactory.IHarvestFactory;
import by.belarusian.farmer.utils.PrintUtil;

import java.util.List;

public class BerriesDecorator implements IHarvestFactory {

    private final IHarvestFactory berriesFactory;

    public BerriesDecorator(IHarvestFactory berriesFactory) {
        this.berriesFactory = berriesFactory;
    }

    @Override
    public Harvest create(String name) {
        final Harvest harvest = berriesFactory.create(name);
        PrintUtil.print("Create " + harvest);
        return harvest;
    }

    @Override
    public List<Harvest> of(int amount) {
        final List<Harvest> harvests = berriesFactory.of(amount);
        PrintUtil.print("Create " + amount + " harvests: " + harvests);
        return harvests;
    }
}
