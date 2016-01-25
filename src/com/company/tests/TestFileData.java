package com.company.tests;

import com.company.files.*;
import com.company.utils.Collections;
import com.company.utils.Utils;

import java.text.MessageFormat;
import java.util.HashMap;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestFileData {
    public final static int TABLE_WIDTH = 70;
    public final static String TEXT_FILE_EXT = ".txt";
    public final static String AUDIO_FILE_EXT = ".aud";
    public final static String IMAGE_FILE_EXT = ".img";
    public final static String TEXT_DATA_MESSAGE = "Text data: {0}";
    public final static String FILE_DATA_MESSAGE = "File[{0}]: name - {1}, type - {2}";
    public static final String SORTED_FILENAME_LIST = "Sorted list of filenames:";
    public static final String SORTED_FILE_LIST = "Sorted list of files:";
    // --------------------------------------------------------------

    public static final String TEST_TEXT = "Test Text";
    public static final String TEST_DIRECTORY = "Test Directory";

    private SimpleFile simpleFile = null;
    private TextFile textFile = null;
    private AudioFile audioFile = null;
    private ImageFile imageFile = null;
    private Directory directory = null;
    private String testFilename;

    public String getTestFilename() {
        return testFilename;
    }

    public void setTestFilename(String testFilename) {
        this.testFilename = testFilename;
    }

    private void initFileData() {
        simpleFile = new SimpleFile(getTestFilename());
        textFile = new TextFile(getTestFilename() + TEXT_FILE_EXT, TEST_TEXT);
        audioFile = new AudioFile(getTestFilename() + AUDIO_FILE_EXT);
        imageFile = new ImageFile(getTestFilename() + IMAGE_FILE_EXT);
    }

    private void initDirectoryData() {
        directory = new Directory(TEST_DIRECTORY);

        directory.addFile(textFile);
        directory.addFile(imageFile);
        directory.addFile(audioFile);
    }

    private void showDirectoryData() {
        HashMap<String, SimpleFile> fileList = directory.getFiles();
        int commonCount = fileList.size();
        Object[] directoryData = fileList.values().toArray();

        for (int i=0; i < commonCount; i++)
            Utils.printMessage(MessageFormat.format(FILE_DATA_MESSAGE, i,
                    ((SimpleFile)directoryData[i]).getFileName(),
                    ((SimpleFile)directoryData[i]).getFileType()));
    }

    public void demonstrateDirectoryData() {
        initDirectoryData();
        showDirectoryData();

        Utils.printMessage(SORTED_FILENAME_LIST);
        // Show as a table
        String className = Utils.getClassName();
        Collections.printListAsTable(directory.getSortedFileNameList(), className, TABLE_WIDTH);

        directory.sortDirectoryByFilename();
        Utils.printMessage(SORTED_FILE_LIST);
        showDirectoryData();
    }


    private void showFileData() {
        Utils.printMessage(Utils.getClassNameMessage(simpleFile));
// ---------------

        Utils.printMessage(Utils.getClassNameMessage(textFile));
        Utils.printMessage(MessageFormat.format(TEXT_DATA_MESSAGE, textFile.getText()));

        Utils.printMessage(Utils.getClassNameMessage(audioFile));
        Utils.printMessage(Utils.getClassNameMessage(imageFile));
    }

    public void demonstrateFileData() {
        initFileData();
        showFileData();
    }
// ----------------------------------------

    public void demonstrateData(String testFilename) {
        setTestFilename(testFilename);
        
        demonstrateFileData();
        demonstrateDirectoryData();
    }
}
