package by.belarusian.farmer.model.berries;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Berry;

public class Gooseberry extends Berry {

    public static final String rusName = "Крыжовник";

    public Gooseberry() {
    }

    public Gooseberry(int weight, Color color) {
        super(weight, color);
    }

        @Override
        public String getRusName() {
            return rusName;
        }
    }
