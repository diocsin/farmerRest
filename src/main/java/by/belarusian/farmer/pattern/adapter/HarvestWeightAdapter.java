package by.belarusian.farmer.pattern.adapter;

import by.belarusian.farmer.model.Harvest;

public class HarvestWeightAdapter extends Harvest {

    private static final double FUNT_CONVERT_VAL = 0.0022046;

    private final Harvest harvest;

    public HarvestWeightAdapter(Harvest harvest) {
        this.harvest = harvest;
    }

    @Override
    public double getWeight() {
        return harvest.getWeight() * FUNT_CONVERT_VAL;
    }
}
