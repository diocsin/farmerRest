package by.belarusian.farmer.model.vegetables;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Vegetable;

public class Radish extends Vegetable {

    public static final String rusName = "Редиска";

    public Radish() {
    }

    public Radish(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
