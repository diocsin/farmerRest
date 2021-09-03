package by.belarusian.farmer.pattern.abstractfactory;

import by.belarusian.farmer.enums.HarvestType;

public class HarvestFactoryProvider {

    public static IHarvestFactory getFactory(final HarvestType harvestType) {
        if (HarvestType.BERRIES.equals(harvestType)) {
            return new BerriesFactory();
        } else if (HarvestType.FRUITS.equals(harvestType)) {
            return new FruitsFactory();
        } else if (HarvestType.VEGETABLES.equals(harvestType)) {
            return new VegetablesFactory();
        }
        throw new IllegalArgumentException("Illegal harvest type");
    }
}
