package by.belarusian.farmer.utils;

import by.belarusian.farmer.model.Harvest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HarvestUtil {

    public static <T extends Harvest> List<T> filterHarvest(List<T> collection, Predicate<T> predicate) {
        return Optional.ofNullable(collection).orElse(Collections.emptyList())
                .stream().filter(predicate).collect(Collectors.toList());
    }


}
