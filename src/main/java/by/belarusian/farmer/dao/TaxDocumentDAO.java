package by.belarusian.farmer.dao;

import by.belarusian.farmer.model.TaxDocument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxDocumentDAO implements ITaxDocumentDAO {

    private final List<TaxDocument> taxDocuments = new ArrayList<>();

    @Override
    public void addDocuments(List<TaxDocument> documents) {
        taxDocuments.addAll(documents);
    }

    @Override
    public List<TaxDocument> getTaxDocuments() {
        return taxDocuments;
    }


}
