package by.belarusian.farmer.pattern.abstractfactory;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.exception.HarvestNotFoundException;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.vegetables.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class VegetablesFactory implements IHarvestFactory {

    private final static Map<String, BiFunction<Integer, Color, Harvest>> vegetablesMap = new HashMap<>();
    private final static Color[] colors = Color.values();
    private final static int[] bound = new int[]{500, 1000};

    static {
        vegetablesMap.put(Beet.rusName, Beet::new);
        vegetablesMap.put(Carrot.rusName, Carrot::new);
        vegetablesMap.put(Cucumber.rusName, Cucumber::new);
        vegetablesMap.put(Pepper.rusName, Pepper::new);
        vegetablesMap.put(Potato.rusName, Potato::new);
        vegetablesMap.put(Radish.rusName, Radish::new);
        vegetablesMap.put(Tomato.rusName, Tomato::new);
    }

    @Override
    public Harvest create(final String name) {
        final BiFunction<Integer, Color, Harvest> biFunction = vegetablesMap.get(name);
        if (biFunction != null) {
            return generateHarvest(biFunction);
        } else {
            throw new HarvestNotFoundException("No such vegetable " + name);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Harvest> of(final int amount) {
        final List<Harvest> harvestList = new ArrayList<>();
        final Map.Entry<String, BiFunction<Integer, Color, Harvest>>[] harvest = vegetablesMap.entrySet().toArray(new Map.Entry[0]);
        for (int i = 0; i < amount; i++) {
            harvestList.add(generateHarvest(harvest[ThreadLocalRandom.current().nextInt(harvest.length)].getValue()));
        }
        return harvestList;
    }

    private Harvest generateHarvest(BiFunction<Integer, Color, Harvest> function) {
        return function.apply(ThreadLocalRandom.current().nextInt(bound[0], bound[1]), colors[ThreadLocalRandom.current().nextInt(colors.length)]);
    }
}
