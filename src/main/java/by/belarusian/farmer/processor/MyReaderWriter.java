package by.belarusian.farmer.processor;

import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

abstract class MyReaderWriter<T> {

    private final String filePath;

    private Path path;

    protected final Class<T> clazz;

    protected BufferedReader fileReader;

    protected BufferedWriter fileWriter;

    MyReaderWriter(String filePath, Class<T> clazz) {
        this.filePath = filePath;
        this.clazz = clazz;
    }

    void prepareForReadFile() throws IOException {
        createPath();
        createReader();
        doSpecialClassReader();
        doPrepareFoIterate();
    }

    void prepareForWriteFile() throws IOException {
        createPath();
        createWriter();
        doSpecialClassWriter();
    }

    private void createPath() {
        path = Paths.get(filePath);
    }

    void createReader() throws IOException {
        fileReader = Files.newBufferedReader(path);
    }

    void createWriter() throws IOException {
        fileWriter = Files.newBufferedWriter(path);
    }

    abstract void doSpecialClassReader();

    abstract void doSpecialClassWriter();

    abstract void doPrepareFoIterate() throws IOException;

    abstract boolean hasNext() throws IOException;

    abstract T doBean();

    abstract void write(List<T> list) throws CsvException;

    abstract void closeRead() throws IOException;

    abstract void closeWriter() throws IOException;

    String getFilePath() {
        return filePath;
    }
}
