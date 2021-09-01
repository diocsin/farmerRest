package by.belarusian.farmer.service;

import by.belarusian.farmer.dao.HarvestDao;
import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Banana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FruitsServiceImpl implements FruitsService {

    private final HarvestDao dao;

    @Autowired
    public FruitsServiceImpl(@Qualifier("fruitsDAO") HarvestDao dao) {
        this.dao = dao;
    }
    @Override
    public Harvest saveBanana(Banana banana) {
        dao.getAll().add(banana);
        return banana;
    }

    @Override
    public Optional<Harvest> createFruit(String name) {
        return dao.create(name);
    }

    @Override
    public List<Harvest> getAllHarvests() {
        return dao.getAll();
    }

    @Override
    public Optional<Harvest> getHarvestById(Long id) {
        final List<Harvest> harvests = dao.getAll();
        return harvests.stream().filter(harvest -> harvest.getId().equals(id)).findAny();
    }

    @Override
    public List<Harvest> findHarvests(int offset, int limit, String filterColor) {
        final List<Harvest> harvests = dao.getAll();
        if (filterColor != null && !filterColor.isEmpty()) {
            final Color color = Color.valueOf(filterColor);
            return harvests.stream().filter(h -> h.getColor().equals(color)).skip(offset).limit(limit).collect(Collectors.toList());
        }
        return harvests.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }
}
