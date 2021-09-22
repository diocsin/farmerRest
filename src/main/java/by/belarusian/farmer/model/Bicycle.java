package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Color;

public class Bicycle {

    private final Basket basket;
    private final Farmer farmer;
    private final Color color;
    private final double weight;
    private final double price;
    private final boolean isElectric;
    private final String factoryName;


    public static class Builder {
        private final Color color;
        private final double weight;

        private Basket basket;
        private Farmer farmer;
        private double price;
        private boolean isElectric;
        private String factoryName;

        public Builder(Color color, double weight) {
            this.color = color;
            this.weight = weight;
        }

        public Builder basket(Basket val) {
            basket = val;
            return this;
        }

        public Builder farmer(Farmer val) {
            farmer = val;
            return this;
        }

        public Builder price(double val) {
            price = val;
            return this;
        }

        public Builder isElectric(boolean val) {
            isElectric = val;
            return this;
        }

        public Builder factoryName(String val) {
            factoryName = val;
            return this;
        }

        public Bicycle build() {
            return new Bicycle(this);
        }

    }

    public Bicycle(Builder builder) {
        basket = builder.basket;
        farmer = builder.farmer;
        color = builder.color;
        weight = builder.weight;
        price = builder.price;
        isElectric = builder.isElectric;
        factoryName = builder.factoryName;
    }

    public Basket getBasket() {
        return basket;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public Color getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public String getFactoryName() {
        return factoryName;
    }
}
