package by.belarusian.farmer.processor;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MyJsonReaderWriter<T> extends MyReaderWriter<T> {

    private JsonReader reader;
    private JsonWriter writer;
    private final Gson gson = new Gson();

    MyJsonReaderWriter(String filePath, Class<T> clazz) {
        super(filePath, clazz);
    }

    @Override
    void doSpecialClassReader() {
        reader = new JsonReader(fileReader);
    }

    @Override
    void doSpecialClassWriter() {
        writer = new JsonWriter(fileWriter);
    }

    @Override
    void doPrepareFoIterate() throws IOException {
        reader.beginArray();
    }

    @Override
    boolean hasNext() throws IOException {
        return reader.hasNext();
    }

    @Override
    void closeRead() throws IOException {
        reader.endArray();
        fileReader.close();
    }

    @Override
    void closeWriter() throws IOException {
        writer.close();
    }

    @Override
    T doBean() {
        final Gson gson = new Gson();
        return gson.fromJson(reader, clazz);
    }

    @Override
    void write(List<T> list) throws CsvException {
        gson.toJson(list, ArrayList.class, writer);
    }
}
