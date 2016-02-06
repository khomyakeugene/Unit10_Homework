package com.company.file;

import com.company.caesar.Caesar;
import com.company.utils.TestUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static com.company.utils.TestUtil.assertArrayListEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yevgen on 06.02.2016 as a part of the project "Unit10_Homework".
 */
public class TextFileTest {
    final static int DEFAULT_SHIFT = 30;

    final static String FILENAME_FOR_READING = "read.txt";
    final static String FILENAME_FOR_WRITING = "write.txt";
    private static ArrayList<String> writingText;

    private static void prepareTestDataForWriting() {
        writingText = new ArrayList<>();

        writingText.add("This is an example");
        writingText.add("of a file writing");
        writingText.add("and a file reading");
    }

    private static void prepareTestDataForReading() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        prepareTestDataForWriting();
        prepareTestDataForReading();
    }

    @Test
    public void testGetAbsoluteFileName() throws Exception {
        final String result = TextFile.getAbsoluteFileName(FILENAME_FOR_WRITING);

        final String expected = new File(FILENAME_FOR_WRITING).getAbsolutePath();
        assertEquals(expected, result);
    }

    @Test
    public void testWriteListToFile() throws Exception {
        final String fileName = TextFile.writeListToFile(FILENAME_FOR_WRITING, writingText);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(writingText, result);
    }


    @Test
    public void testWriteEncodedListToFile() throws Exception {
        final String fileName = TextFile.writeEncodedListToFile(FILENAME_FOR_WRITING, writingText, DEFAULT_SHIFT);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(writingText, Caesar.decodeList(result, DEFAULT_SHIFT));
    }

    @Test
    public void testWriteEncodedUsingDefaultShiftListToFile() throws Exception {
        final String fileName = TextFile.writeEncodedUsingDefaultShiftListToFile(FILENAME_FOR_WRITING, writingText);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(writingText, Caesar.decodeList(result, TextFile.DEFAULT_SHIFT));
    }

    @Test
    public void testReadListFromFile() throws Exception {
        // ArrayList<String> result = TextFile.readListFromFile()

    }

    @Test
    public void testReadDecodedListFromFile() throws Exception {

    }

    @Test
    public void testReadDecodedUsingDefaultShiftListToFile() throws Exception {

    }
}