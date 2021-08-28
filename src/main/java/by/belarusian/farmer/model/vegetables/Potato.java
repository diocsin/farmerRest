package by.belarusian.farmer.model.vegetables;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Vegetable;

public class Potato extends Vegetable {

    public static final String rusName = "Картофель";

    public Potato() {
    }

    public Potato(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
