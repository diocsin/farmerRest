package by.belarusian.farmer.model.vegetables;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Vegetable;


public class Cucumber extends Vegetable {

    public static final String rusName = "Огурец";

    public Cucumber() {
    }

    public Cucumber(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}
