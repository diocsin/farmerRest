package by.belarusian.farmer.processor;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class MyCsvReaderWriter<T> extends MyReaderWriter<T> {

    private CsvToBean<T> csvToBean;
    private StatefulBeanToCsv<T> beanToCsv;
    private Iterator<T> iterator;

    MyCsvReaderWriter(String filePath, Class<T> clazz) {
        super(filePath, clazz);
    }

    @Override
    void doSpecialClassReader() {
        csvToBean = new CsvToBeanBuilder<T>(fileReader)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withType(clazz)
                .build();
    }

    @Override
    @SuppressWarnings("unchecked")
    void doSpecialClassWriter() {
        beanToCsv = new StatefulBeanToCsvBuilder(fileWriter)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
    }

    @Override
    boolean hasNext() throws IOException {
        return iterator.hasNext();
    }

    @Override
    void doPrepareFoIterate() throws IOException {
        iterator = csvToBean.iterator();
    }

    @Override
    void closeRead() throws IOException {
        fileReader.close();
    }

    @Override
    T doBean() {
        return iterator.next();
    }

    @Override
    void write(List<T> list) throws CsvException {
        beanToCsv.write(list);
    }

    @Override
    void closeWriter() throws IOException {
        fileWriter.close();
    }
}
