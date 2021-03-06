package com.company.file;

import com.company.caesar.Caesar;
import com.company.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevgen on 25.01.2016 as a part of the project "Unit10_Homework".
 */
public class TextFile {
    public final static String CANNOT_OPEN_FILE_TO_WRITE_PATTERN = "Cannot open file \"%s\" to write!";
    public final static String CANNOT_CLOSE_FILE_PATTERN = "Cannot close file \"%s\"!";
    public final static String CANNOT_WRITE_ROW_TO_FILE_PATTERN = "Cannot write row \"%s\" to file \"%s\"!";
    public final static String CANNOT_OPEN_FILE_TO_READ_PATTERN = "Cannot open file \"%s\" to read!";
    public final static int DEFAULT_SHIFT = 20;

    public static String getAbsoluteFileName(String fileName) {
        String fullFileName;

        File file = new File(fileName);
        try {
             fullFileName = file.getAbsolutePath();
        } catch (SecurityException e) {
             // If it is impossible to get absolute path, interpret source filename as an absolute one
             fullFileName = fileName;
        }

        return fullFileName;   
    }

    public static String writeListToFile(String fileName, List list) {
        String fullFileName = null;
        BufferedWriter bufferedWriter = null;

        // In this method we intentionally do not use try-with-resources just to have the possibility to handle
        // different input/output errors
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            } catch (IOException e) {
                Utils.printMessage(String.format(CANNOT_OPEN_FILE_TO_WRITE_PATTERN, fileName));
                Utils.printMessage(e.getMessage());
                bufferedWriter = null;
            }

            // Write text data by lines
            if (bufferedWriter != null) {
                // Store filename with absolute path
                fullFileName = getAbsoluteFileName(fileName);

                // Save data to file
                String string;
                for (Object object : list) {
                    string = object.toString();
                    try {
                        bufferedWriter.write(string);
                        bufferedWriter.newLine();
                    } catch (IOException e) {
                        // As a sign of error
                        fullFileName = null;
                        // Indicate error message 
                        Utils.printMessage(String.format(CANNOT_WRITE_ROW_TO_FILE_PATTERN, string, fileName));
                        Utils.printMessage(e.getMessage());
                        break;
                    }
                }
            }
        } finally {
            // Close file
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    // As a sign of error
                    fullFileName = null;
                    // Indicate error message 
                    Utils.printMessage(String.format(CANNOT_CLOSE_FILE_PATTERN, fileName));
                    Utils.printMessage(e.getMessage());
                }
            }
        }

        // Return absolute path as a sign that file has been successfully saved
        return fullFileName;
    }

    public static String writeEncodedListToFile(String fileName, List<? extends Object>  list, int shift) {
        return writeListToFile(fileName, Caesar.encodeList(list, shift));
    }

    public static String writeEncodedUsingDefaultShiftListToFile(String fileName, List<? extends Object> list) {
        return writeEncodedListToFile(fileName, list, DEFAULT_SHIFT);
    }

    public static ArrayList<String> readListFromFile(String fileName) {
        ArrayList<String> resultList = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                Utils.printMessage(String.format(CANNOT_OPEN_FILE_TO_READ_PATTERN, fileName));
                Utils.printMessage(e.getMessage());
                bufferedReader = null;
            }

            // Read text data by lines
            if (bufferedReader != null) {
                bufferedReader.lines().forEach(resultList::add);
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // Indicate error message
                    Utils.printMessage(String.format(CANNOT_CLOSE_FILE_PATTERN, fileName));
                    Utils.printMessage(e.getMessage());
                }
            }
        }

        return resultList;
    }

    public static ArrayList<String> readDecodedListFromFile(String fileName, int shift) {
        return Caesar.decodeList(readListFromFile(fileName), shift);
    }

    public static ArrayList<String> readDecodedUsingDefaultShiftListToFile(String fileName) {
        return readDecodedListFromFile(fileName, DEFAULT_SHIFT);
    }
}
