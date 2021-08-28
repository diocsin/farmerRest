package by.belarusian.farmer.model.fruits;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Fruit;

public class Apricot extends Fruit {

    public static final String rusName = "Абрикос";

    public Apricot() {
    }

    public Apricot(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}


