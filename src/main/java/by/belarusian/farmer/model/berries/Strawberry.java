package by.belarusian.farmer.model.berries;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Berry;

public class Strawberry extends Berry {

    public static final String rusName = "Клубника";

    public Strawberry() {
    }

    public Strawberry(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
