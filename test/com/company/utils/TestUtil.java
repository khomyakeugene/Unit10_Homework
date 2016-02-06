package com.company.utils;

import org.junit.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Yevgen on 06.02.2016 as a part of the project "Unit9_Homework".
 */
public class TestUtil {
    public static void assertArrayListEquals(ArrayList<? extends Object> expected, ArrayList<? extends Object> actual) {
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    public static ArrayList<String> readFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(list);
    }


    public static String saveToFile(String fileName, List<? extends Object> list) {
        fileName = new File(fileName).getAbsolutePath();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            list.
                    stream().
                    forEach(p -> {
                        try {
                            bufferedWriter.write(p.toString());
                            bufferedWriter.newLine();
                        } catch  (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }


    public static boolean deleteFile(String fileName) {
        boolean result;

        try {
            result = Files.deleteIfExists(FileSystems.getDefault().getPath("", new File(fileName).getAbsolutePath()));

        } catch (IOException e) {
            result = false;
        }

        return result;
    }
}
