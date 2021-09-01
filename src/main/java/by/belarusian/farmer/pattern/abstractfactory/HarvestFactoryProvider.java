package by.belarusian.farmer.pattern.abstractfactory;

import by.belarusian.farmer.enums.HarvestType;

public class HarvestFactoryProvider {

    public static IHarvestFactory getFactory(final HarvestType harvestType) {
        if (HarvestType.BERRIES.equals(harvestType)) {
            return new BerriesFactoryI();
        } else if (HarvestType.FRUITS.equals(harvestType)) {
            return new FruitsFactoryI();
        } else if (HarvestType.VEGETABLES.equals(harvestType)) {
            return new VegetablesFactoryI();
        }
        throw new IllegalArgumentException("Illegal harvest type");
    }
}
