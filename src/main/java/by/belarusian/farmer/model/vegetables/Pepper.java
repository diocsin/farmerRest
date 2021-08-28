package by.belarusian.farmer.model.vegetables;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Vegetable;


public class Pepper extends Vegetable {

    public static final String rusName = "Перец";

    public Pepper() {
    }

    public Pepper(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
