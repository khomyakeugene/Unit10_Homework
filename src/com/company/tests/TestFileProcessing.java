package com.company.tests;

import com.company.utils.TextMessage;
import com.company.utils.Utils;
import file.TextFile;

import java.util.ArrayList;

/**
 * Created by Yevgen on 25.01.2016 as a part of the project "Unit10_Homework".
 */
public class TestFileProcessing {
    public final static String INPUT_TEXT_MESSAGE = "Please, input text (at least, one row)";
    public final static String INPUT_FILENAME_MESSAGE = "Please, input filename:";

    private String fileName;
    private ArrayList<String> text;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void initData() {
        text = TextMessage.readNotEmptyInputText(INPUT_TEXT_MESSAGE);
        setFileName(Utils.readNotInputInputString(INPUT_FILENAME_MESSAGE));

    }


    public void processData() {
        // Write to file
        TextFile.writeListToFile(getFileName(), getText());
        // Read from file

        // Show "source" text

        // Encode text

        // Show encoded text
    }


    public void demonstrate() {
        initData();
        processData();
    }
}
