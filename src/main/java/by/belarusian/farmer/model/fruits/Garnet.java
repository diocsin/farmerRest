package by.belarusian.farmer.model.fruits;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Fruit;

public class Garnet extends Fruit {
    public static final String rusName = "Гранат";

    public Garnet() {
    }

    public Garnet(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
