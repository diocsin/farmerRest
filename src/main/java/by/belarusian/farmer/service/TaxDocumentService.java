package by.belarusian.farmer.service;

import by.belarusian.farmer.model.TaxDocument;

import java.util.List;

public interface TaxDocumentService {

    List<TaxDocument> createTaxDocument();

    void writeCsvFile(String path) throws Exception;

    List<TaxDocument> readCsvFile(String path) throws Exception;
}
