package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.HarvestType;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Harvest {

    private final HarvestType harvestType;

    private double weight;

    private Color color;

    private Long id;

    private static AtomicLong atomicLong = new AtomicLong();

    public Harvest() {
        harvestType = null;
        id = atomicLong.incrementAndGet();
    }

    public Harvest(int weight, Color color, HarvestType harvestType) {
        id = atomicLong.incrementAndGet();
        this.weight = weight;
        this.color = color;
        this.harvestType = harvestType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public HarvestType getType() {
        return harvestType;
    }


    public String getRusName() {
        return "Плод";
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getType().getRusName() + " - " + this.getRusName() + " " + this.getWeight() + " грамм, цвет - " + this.getColor().getRusName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Harvest harvest = (Harvest) o;
        return weight == harvest.weight &&
                harvestType == harvest.harvestType &&
                color == harvest.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(harvestType, weight, color);
    }
}
