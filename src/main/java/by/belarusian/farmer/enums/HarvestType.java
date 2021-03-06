package by.belarusian.farmer.enums;

public enum HarvestType {
    VEGETABLES(1, "Овощи"),
    FRUITS(2, "Фрукты"),
    BERRIES(3, "Ягоды");

    private final int index;
    private final String rusName;

    HarvestType(int index, String rusName) {
        this.index = index;
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }

    public int getIndex() {
        return index;
    }

}
