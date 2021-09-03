package by.belarusian.farmer.pattern.abstractfactory;

import by.belarusian.farmer.enums.HarvestType;
import by.belarusian.farmer.pattern.decorator.BerriesDecorator;
import by.belarusian.farmer.pattern.decorator.FruitsDecorator;
import by.belarusian.farmer.pattern.decorator.VegetablesDecorator;

public class HarvestFactoryProvider {

    public static IHarvestFactory getFactory(final HarvestType harvestType) {
        if (HarvestType.BERRIES.equals(harvestType)) {
            return new BerriesDecorator(new BerriesFactory());
        } else if (HarvestType.FRUITS.equals(harvestType)) {
            return new FruitsDecorator(new FruitsFactory());
        } else if (HarvestType.VEGETABLES.equals(harvestType)) {
            return new VegetablesDecorator(new VegetablesFactory());
        }
        throw new IllegalArgumentException("Illegal harvest type");
    }
}
