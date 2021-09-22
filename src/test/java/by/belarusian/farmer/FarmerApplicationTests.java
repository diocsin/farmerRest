package by.belarusian.farmer;

import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.enums.HarvestType;
import by.belarusian.farmer.model.Basket;
import by.belarusian.farmer.model.Bicycle;
import by.belarusian.farmer.model.Farmer;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Apple;
import by.belarusian.farmer.pattern.abstractfactory.HarvestFactoryProvider;
import by.belarusian.farmer.pattern.abstractfactory.IHarvestFactory;
import by.belarusian.farmer.pattern.adapter.HarvestWeightAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FarmerApplicationTests {

    @Test
    void convertWeightTest() {
        Harvest apple = new Apple(1000, Color.GREEN);
        Harvest adapter = new HarvestWeightAdapter(apple);
        assertEquals(2.2046, adapter.getWeight(), "Adapter to Funts wrong");
    }

    @Test
    void addListenerTest() {
        final IHarvestFactory factory = HarvestFactoryProvider.getFactory(HarvestType.BERRIES);
        final Harvest harvest = factory.create("Вишня");
        final Harvest harvestForAdd = factory.create("Вишня");
        final List<Basket> baskets = Basket.of(Collections.singletonList(harvest));
        final Farmer farmer = new Farmer();
        baskets.forEach(b -> {
            b.eventManager.subscribe("addHarvest", farmer);
            b.eventManager.subscribe("create", farmer);
        });
        baskets.get(0).addHarvests(Collections.singletonList(harvestForAdd));
    }

    @Test
    void addListenerSupportTest() {
        final IHarvestFactory factory = HarvestFactoryProvider.getFactory(HarvestType.BERRIES);
        final Harvest harvest = factory.create("Вишня");
        final Harvest harvestForAdd = factory.create("Вишня");
        final List<Basket> baskets = Basket.of(Collections.singletonList(harvest));
        final Farmer farmer = new Farmer();
        baskets.forEach(b -> {
            b.support.addPropertyChangeListener("ad", farmer);
        });
        baskets.get(0).addHarvests(Collections.singletonList(harvestForAdd));
    }

    @Test
    void builderBicycle() {
        Bicycle bicycle = new Bicycle.Builder(Color.GREEN, 15000)
                .isElectric(true)
                .factoryName("Аист")
                .farmer(new Farmer())
                .build();

        assertEquals(15000, bicycle.getWeight());

    }


}
