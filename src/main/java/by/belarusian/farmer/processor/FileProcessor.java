package by.belarusian.farmer.processor;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class FileProcessor<T> {

    abstract MyReaderWriter<T> createReaderWriter(String fileName);

    abstract List<T> generalImport(Optional<MyReaderWriter<T>> optReader) throws Exception;

    public void writeFile(List<T> taxDocuments, String path) throws IOException, CsvException {
        MyReaderWriter<T> writer = createReaderWriter(path);
        writer.prepareForWriteFile();
        writer.write(taxDocuments);
        writer.closeWriter();
    }

    public List<T> readFile(String path) throws Exception {
        MyReaderWriter<T> reader = createReaderWriter(path);
        return generalImport(Optional.of(reader));
    }

}
