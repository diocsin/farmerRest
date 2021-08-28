package by.belarusian.farmer.model.berries;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Berry;

public class Currant extends Berry {

    public static final String rusName = "Смородина";

    public Currant() {
    }

    public Currant(int weight, Color color) {
        super(weight, color);
    }

    @Override
    public String getRusName() {
        return rusName;
    }
}


