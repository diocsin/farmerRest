package by.belarusian.farmer.model.fruits;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Fruit;

public class Guava extends Fruit {

    public static final String rusName = "Гуава";

    public Guava() {
    }

    public Guava(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
