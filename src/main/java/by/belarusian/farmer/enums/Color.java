package by.belarusian.farmer.enums;

public enum Color {
    GREEN(1, "Зелёный"),
    RED(2, "Красный"),
    BLUE(3, "Синий"),
    WHITE(4, "Белый"),
    BLACK(5, "Чёрный"),
    YELLOW(6, "Жёлтый"),

    ORANGE(7, "Оранжевый"),
    PURPLE(8, "Фиолетовый"),
    GREY(9, "Серый"),
    BROWN(10, "Коричневый"),
    SALAD(11, "Салатовый");

    private final int index;
    private final String rusName;

    Color(int index, String rusName) {
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
