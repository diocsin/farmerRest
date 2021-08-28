package by.belarusian.farmer.model;

import java.util.Optional;

public class Bicycle {

    private Optional<Basket> basket = Optional.empty();

    public Bicycle(Optional<Basket> basket) {
        this.basket = basket;
    }

    public Bicycle() {
    }

    public Optional<Basket> getBasket() {
        return basket;
    }

    public void setBasket(Optional<Basket> basket) {
        this.basket = basket;
    }
}
