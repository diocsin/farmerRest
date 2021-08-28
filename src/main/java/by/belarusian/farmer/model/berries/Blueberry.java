package by.belarusian.farmer.model.berries;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Berry;

public class Blueberry extends Berry {

    public static final String rusName = "Черника";

    public Blueberry() {
    }

    public Blueberry(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
