package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.Type;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Basket {

    private int totalWeight;
    private List<Harvest> harvests;
    private final Type type;
    private static final int MAX = 1000;

    public Basket(List<Harvest> harvests) {
        this.harvests = harvests;
        this.totalWeight = takeTotalWeight(harvests);
        type = Optional.ofNullable(harvests.get(0).getType()).orElse(null);
    }

    public static List<Basket> of(List<Harvest> harvests) {
        Map<Type, List<Harvest>> collect = harvests.stream().collect(groupingBy(Harvest::getType));

        Function<List<Harvest>, List<Basket>> harvestsBasketsFunction = harvestList -> {
            List<Basket> baskets = new ArrayList<>();
            int tempWeight = 0;
            List<Harvest> tempHarvestList = new ArrayList<>();
            for (Harvest harvest : harvestList) {
                if (harvest.getWeight() + tempWeight > 1000) {
                    tempWeight = 0;
                    baskets.add(new Basket(tempHarvestList));
                    tempHarvestList = new ArrayList<>();
                }
                tempWeight += harvest.getWeight();
                tempHarvestList.add(harvest);
            }
            baskets.add(new Basket(tempHarvestList));
            return baskets;
        };
        return collect.values().stream().map(harvestsBasketsFunction).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private int takeTotalWeight(List<Harvest> harvests) {
        return harvests.stream().mapToInt(Harvest::getWeight).sum();
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public List<Harvest> getHarvests() {
        return harvests;
    }

    public boolean addHarvests(List<Harvest> harvests) {
        if (this.totalWeight + harvests.stream().mapToInt(Harvest::getWeight).sum() > 1000
                || !harvests.stream().allMatch(harvest -> harvest.getType().equals(this.type))) {
            return false;
        }
        return this.harvests.addAll(harvests);
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "totalWeight=" + totalWeight +
                ", harvests=" + harvests.size() +
                '}';
    }
}
