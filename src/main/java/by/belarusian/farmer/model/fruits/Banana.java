package by.belarusian.farmer.model.fruits;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Fruit;

public class Banana extends Fruit {
    public static final String rusName = "Банан";

    public Banana() {
    }

    public Banana(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }

}
