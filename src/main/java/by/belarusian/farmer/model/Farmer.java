package by.belarusian.farmer.model;

import by.belarusian.farmer.pattern.observer.EventListener;
import by.belarusian.farmer.utils.PrintUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Optional;

public class Farmer implements EventListener, PropertyChangeListener {

    private Optional<Bicycle> bicycle;

    public Farmer(Optional<Bicycle> bicycle) {
        this.bicycle = bicycle;
    }

    public Farmer() {
    }

    public Optional<Bicycle> getBicycle() {
        return bicycle;
    }

    public void setBicycle(Optional<Bicycle> bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public void update(String eventType, Object object) {
        PrintUtil.print(eventType + " " + object);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PrintUtil.print("Добавили" + evt.getNewValue());
    }
}
