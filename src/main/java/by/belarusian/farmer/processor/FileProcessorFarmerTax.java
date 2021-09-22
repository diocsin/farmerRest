package by.belarusian.farmer.processor;

import by.belarusian.farmer.exception.ImportException;
import by.belarusian.farmer.model.TaxDocument;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class FileProcessorFarmerTax extends FileProcessor<TaxDocument> {

    MyReaderWriter<TaxDocument> createReaderWriter(String fileName) {
        final String regularCsv = "^.*\\.csv$";
        final String regularJson = "^.*\\.json$";
        final String filePath = fileName;
        MyReaderWriter<TaxDocument> reader = null;
        if (Pattern.matches(regularCsv, fileName)) {
            reader = new MyCsvReaderWriter<>(filePath, TaxDocument.class);
        } else if (Pattern.matches(regularJson, fileName)) {
            reader = new MyJsonReaderWriter<>(filePath, TaxDocument.class);
        }
        return reader;
    }

    @Override
    List<TaxDocument> generalImport(Optional<MyReaderWriter<TaxDocument>> optReader) throws Exception {
        MyReaderWriter<TaxDocument> reader = optReader.orElseThrow(() -> new ImportException("Format file incorrect"));
        List<TaxDocument> taxDocumentList = new ArrayList<>();
        try {
            reader.prepareForReadFile();
            while (reader.hasNext()) {
                TaxDocument taxDocument = reader.doBean();
                taxDocumentList.add(taxDocument);
            }
            System.out.println("Loading done");
            return taxDocumentList;
        } catch (IOException e) {
            throw new ImportException(String.format("Error occurred while reading the file - %s", reader.getFilePath()));
        } finally {
            reader.closeRead();
        }
    }


}
