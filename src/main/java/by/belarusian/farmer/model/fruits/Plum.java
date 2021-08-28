package by.belarusian.farmer.model.fruits;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Fruit;

public class Plum extends Fruit {

    public static final String rusName = "Слива";

    public Plum() {
    }

    public Plum(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
