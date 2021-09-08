package by.belarusian.farmer.dao;

import by.belarusian.farmer.model.TaxDocument;

import java.util.List;

public interface ITaxDocumentDAO {

    void addDocuments(List<TaxDocument> documentList);

    List<TaxDocument> getTaxDocuments();
}
