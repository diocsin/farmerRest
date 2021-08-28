package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.Type;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Harvest {

    private final Type type;

    private int weight;

    private Color color;

    private Long id;

    private static AtomicLong atomicLong = new AtomicLong();

    public Harvest() {
        type = null;
        id = atomicLong.incrementAndGet();
    }

    public Harvest(int weight, Color color, Type type) {
        id = atomicLong.incrementAndGet();
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Type getType() {
        return type;
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
                type == harvest.type &&
                color == harvest.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }
}
