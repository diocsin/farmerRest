package by.belarusian.farmer.model;

import java.util.Optional;

public class Farmer {

    private Optional<Bicycle> bicycle;

    public Farmer(Optional<Bicycle> bicycle) {
        this.bicycle = bicycle;
    }

    public Farmer() {
    }

    public Optional<Bicycle> getBicycle() {
        return bicycle;
    }

    public void setBicycle(Optional<Bicycle> bicycle) {
        this.bicycle = bicycle;
    }
}
