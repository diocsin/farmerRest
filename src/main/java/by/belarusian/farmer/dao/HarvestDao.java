package by.belarusian.farmer.dao;

import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.utils.HarvestFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HarvestDao {

    private static final int AMOUNT_HARVESTS = 1000;

    public static final List<Harvest> harvests = HarvestFactory.of(AMOUNT_HARVESTS);

    public List<Harvest> getAll() {
        return harvests;
    }
}
