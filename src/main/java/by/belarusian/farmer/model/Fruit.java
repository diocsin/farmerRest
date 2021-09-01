package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.HarvestType;

public abstract class Fruit extends Harvest {

    public Fruit() {
    }

    public Fruit(int weight, Color color) {
        super(weight, color, HarvestType.FRUITS);

    }
}
