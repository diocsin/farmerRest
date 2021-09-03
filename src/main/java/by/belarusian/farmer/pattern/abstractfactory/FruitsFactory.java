package by.belarusian.farmer.pattern.abstractfactory;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.exception.HarvestNotFoundException;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class FruitsFactory implements IHarvestFactory {

    private final static Map<String, BiFunction<Integer, Color, Harvest>> fruitsMap = new HashMap<>();
    private final static Color[] colors = Color.values();
    private final static int[] bound = new int[]{500, 1000};

    static {
        fruitsMap.put(Apple.rusName, Apple::new);
        fruitsMap.put(Orange.rusName, Orange::new);
        fruitsMap.put(Apricot.rusName, Apricot::new);
        fruitsMap.put(Banana.rusName, Banana::new);
        fruitsMap.put(Garnet.rusName, Garnet::new);
        fruitsMap.put(Guava.rusName, Guava::new);
        fruitsMap.put(Lemon.rusName, Lemon::new);
        fruitsMap.put(Plum.rusName, Plum::new);
    }

    @Override
    public Harvest create(final String name) {
        final BiFunction<Integer, Color, Harvest> biFunction = fruitsMap.get(name);
        if (biFunction != null) {
            return generateHarvest(biFunction);
        } else {
            throw new HarvestNotFoundException("No such fruit " + name);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Harvest> of(final int amount) {
        final List<Harvest> harvestList = new ArrayList<>();
        final Map.Entry<String, BiFunction<Integer, Color, Harvest>>[] harvest = fruitsMap.entrySet().toArray(new Map.Entry[0]);
        for (int i = 0; i < amount; i++) {
            harvestList.add(generateHarvest(harvest[ThreadLocalRandom.current().nextInt(harvest.length)].getValue()));
        }
        return harvestList;
    }

    private Harvest generateHarvest(BiFunction<Integer, Color, Harvest> function) {
        return function.apply(ThreadLocalRandom.current().nextInt(bound[0], bound[1]), colors[ThreadLocalRandom.current().nextInt(colors.length)]);
    }

}
