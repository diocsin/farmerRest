package by.belarusian.farmer.service;

import by.belarusian.farmer.dao.TaxDocumentDAO;
import by.belarusian.farmer.model.Harvest;
import by.belarusian.farmer.model.TaxDocument;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TaxDocumentServiceImpl implements TaxDocumentService {

    private final HarvestsService harvestsService;

    private final ModelMapper modelMapper;

    private final TaxDocumentDAO documentDAO;

    @Autowired
    public TaxDocumentServiceImpl(@Qualifier("harvestsServiceImpl") HarvestsService harvestsService, ModelMapper modelMapper, TaxDocumentDAO documentDAO) {
        this.harvestsService = harvestsService;
        this.modelMapper = modelMapper;
        this.documentDAO = documentDAO;
    }

    @Override
    public List<TaxDocument> createTaxDocument() {
        final List<Harvest> harvests = harvestsService.getAllHarvests();
        Type listType = new TypeToken<List<TaxDocument>>() {
        }.getType();
        final List<TaxDocument> taxDocuments = modelMapper.map(harvests, listType);
        documentDAO.addDocuments(taxDocuments);
        return taxDocuments;
    }
}
