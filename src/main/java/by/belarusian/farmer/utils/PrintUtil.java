package by.belarusian.farmer.utils;

import by.belarusian.farmer.model.Harvest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class PrintUtil {
    public static final String PATH = "log.txt";

    public static void print(List<Harvest> list) {
        String harvestsPrint = list.stream().map(Harvest::toString).collect(joining("\n"));
        System.out.println(harvestsPrint);
        StringBuilder harvestFormating = new StringBuilder();
        harvestFormating
                .append(new Date().toString())
                .append(System.lineSeparator())
                .append(harvestsPrint);
        // byte[] harvestsPrintBytes = harvestFormating.toString().getBytes();
        Path path = Paths.get(PATH);
        try {
            Files.write(path, harvestFormating.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + e);
        }

    }

    public static void print(String message) {
        StringBuilder harvestFormating = new StringBuilder();
        harvestFormating
                .append("LOG ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm:ss")))
                .append(": ")
                .append(message)
                .append(System.lineSeparator());
        System.out.println(harvestFormating);
        Path path = Paths.get(PATH);
        try {
            Files.write(path, harvestFormating.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + e);
        }

    }

}

