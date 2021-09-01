package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.HarvestType;

public abstract class Vegetable extends Harvest {

    public Vegetable() {
    }

    public Vegetable(int weight, Color color) {
        super(weight, color, HarvestType.VEGETABLES);

    }
}
