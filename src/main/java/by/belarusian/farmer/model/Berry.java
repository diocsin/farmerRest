package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.HarvestType;

public abstract class Berry extends Harvest {

    public Berry() {
    }

    public Berry(int weight, Color color) {
        super(weight, color, HarvestType.BERRIES);

    }

}
