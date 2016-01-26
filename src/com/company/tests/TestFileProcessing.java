package com.company.tests;

import com.company.utils.Collections;
import com.company.utils.TextMessage;
import com.company.utils.Utils;
import com.company.file.TextFile;

import java.util.ArrayList;

/**
 * Created by Yevgen on 25.01.2016 as a part of the project "Unit10_Homework".
 */
public class TestFileProcessing {
    public final static String INPUT_TEXT_MESSAGE = "Please, input text (at least, one row)";
    public final static String INPUT_FILENAME_MESSAGE = "Please, input filename:";
    public final static String FILE_HAS_BEEN_SUCCESSFULLY_SAVED_PATTERN = "File \"%s\" has been successfully saved";
    public final static String READ_FILE_PATTERN = "Read file \"%s\" ...";
    public final static String READ_AND_DECODE_TEXT_FROM_FILE_PATTERN = "Read and decode text from file \"%s\" ...";
    public final static String ENCODED_TEXT_MESSAGE = "Encoded text:";
    public final static String DECODED_TEXT_MESSAGE = "Decoded text:";

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
        String fullFileName = TextFile.writeEncodedUsingDefaultShiftListToFile(getFileName(), getText());
        if (fullFileName != null && !fullFileName.isEmpty()) {
            Utils.printMessage(String.format(FILE_HAS_BEEN_SUCCESSFULLY_SAVED_PATTERN, fullFileName));

            // Read encoded text from file
            Utils.printMessage(String.format(READ_FILE_PATTERN, fullFileName));
            ArrayList<String> encodedList = TextFile.readListFromFile(fullFileName);
            // Show encoded text
            Utils.printMessage(ENCODED_TEXT_MESSAGE);
            Collections.printList(encodedList);

            // Read decoded text from file
            Utils.printMessage(String.format(READ_AND_DECODE_TEXT_FROM_FILE_PATTERN, fullFileName));
            ArrayList<String> decodedList = TextFile.readDecodedUsingDefaultShiftListToFile(fullFileName);
            // Show "source" text
            Utils.printMessage(DECODED_TEXT_MESSAGE);
            Collections.printList(decodedList);
        }
    }

    public void demonstrate() {
        initData();
        processData();
    }
}
