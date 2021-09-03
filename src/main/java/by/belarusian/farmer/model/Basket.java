package by.belarusian.farmer.model;

import by.belarusian.farmer.enums.HarvestType;
import by.belarusian.farmer.pattern.observer.EventManager;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Basket {

    private double totalWeight;
    private List<Harvest> harvests;
    private final HarvestType harvestType;
    private static final double MAX_WEIGHT = 1000;
    public EventManager eventManager;
    public PropertyChangeSupport support;

    public Basket(List<Harvest> harvests) {
        this.harvests = harvests;
        this.totalWeight = takeTotalWeight(harvests);
        harvestType = Optional.ofNullable(harvests.get(0).getType()).orElse(null);
        this.eventManager = new EventManager("create", "addHarvest");
        support = new PropertyChangeSupport(this);
    }

    public static List<Basket> of(List<Harvest> harvests) {
        Map<HarvestType, List<Harvest>> collect = harvests.stream().collect(groupingBy(Harvest::getType));

        Function<List<Harvest>, List<Basket>> harvestsBasketsFunction = harvestList -> {
            List<Basket> baskets = new ArrayList<>();
            double tempWeight = 0;
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

    private double takeTotalWeight(List<Harvest> harvests) {
        return harvests.stream().mapToDouble(Harvest::getWeight).sum();
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public List<Harvest> getHarvests() {
        return harvests;
    }

    public boolean addHarvests(List<Harvest> harvests) {
        if (this.totalWeight + harvests.stream().mapToDouble(Harvest::getWeight).sum() > 1000
                || !harvests.stream().allMatch(harvest -> harvest.getType().equals(this.harvestType))) {
            return false;
        }
        final boolean isAdded = this.harvests.addAll(harvests);
        eventManager.notify("addHarvest", harvests);
        support.firePropertyChange("addHarvestFromSupport", this.harvests, harvests);
        return isAdded;
    }

    public HarvestType getType() {
        return harvestType;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "totalWeight=" + totalWeight +
                ", harvests=" + harvests.size() +
                '}';
    }
}
