package by.belarusian.farmer.model.berries;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Berry;

public class Cranberry extends Berry {

    public static final String rusName = "Клюква";

    public Cranberry() {
    }

    public Cranberry(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
