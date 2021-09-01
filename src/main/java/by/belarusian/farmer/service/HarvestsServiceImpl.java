package by.belarusian.farmer.service;

import by.belarusian.farmer.dao.HarvestDao;
import by.belarusian.farmer.enums.Color;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.fruits.Banana;
import by.belarusian.farmer.utils.HarvestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HarvestsServiceImpl implements HarvestsService {

    private final HarvestDao fruitsDAO;
    private final HarvestDao berriesDAO;
    private final HarvestDao vegetablesDAO;

    @Autowired
    public HarvestsServiceImpl(@Qualifier("fruitsDAO") HarvestDao fruitsDAO,
                               @Qualifier("berriesDAO") HarvestDao berriesDAO,
                               @Qualifier("vegetablesDAO") HarvestDao vegetablesDAO) {
        this.fruitsDAO = fruitsDAO;
        this.berriesDAO = berriesDAO;
        this.vegetablesDAO = vegetablesDAO;
    }

    @Override
    public List<Harvest> getAllHarvests() {
        List<Harvest> harvests = new ArrayList<>();
        harvests.addAll(berriesDAO.getAll());
        harvests.addAll(fruitsDAO.getAll());
        harvests.addAll(vegetablesDAO.getAll());
        return harvests;
    }

    @Override
    public Optional<Harvest> getHarvestById(Long id) {
        List<Harvest> harvests = new ArrayList<>();
        harvests.addAll(berriesDAO.getAll());
        harvests.addAll(fruitsDAO.getAll());
        harvests.addAll(vegetablesDAO.getAll());
        return harvests.stream().filter(harvest -> harvest.getId().equals(id)).findAny();
    }

    @Override
    public List<Harvest> findHarvests(int offset, int limit, String filterColor) {
        List<Harvest> harvests = new ArrayList<>();
        harvests.addAll(berriesDAO.getAll());
        harvests.addAll(fruitsDAO.getAll());
        harvests.addAll(vegetablesDAO.getAll());
        if (filterColor != null && !filterColor.isEmpty()) {
            final Color color = Color.valueOf(filterColor);
            return harvests.stream().filter(h -> h.getColor().equals(color)).skip(offset).limit(limit).collect(Collectors.toList());
        }
        return harvests.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

}
