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
    public final static String CANNOT_READ_FILE_PATTERN = "Cannot open read file \"%s\"!";

    final static int DEFAULT_SHIFT = 30;
    final static String FILENAME = "test.txt";
    private static ArrayList<String> text;

    @BeforeClass
    public static void setUpClass() throws Exception {
        text = new ArrayList<>();
        
        text.add("This is an example");
        text.add("of a file writing");
        text.add("and a file reading");
    }

    @Test
    public void testGetAbsoluteFileName() throws Exception {
        final String result = TextFile.getAbsoluteFileName(FILENAME);

        final String expected = new File(FILENAME).getAbsolutePath();
        assertEquals(expected, result);
    }

    @Test
    public void testWriteListToFile() throws Exception {
        final String fileName = TextFile.writeListToFile(FILENAME, text);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(text, result);
    }


    @Test
    public void testWriteEncodedListToFile() throws Exception {
        final String fileName = TextFile.writeEncodedListToFile(FILENAME, text, DEFAULT_SHIFT);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(text, Caesar.decodeList(result, DEFAULT_SHIFT));
    }

    @Test
    public void testWriteEncodedUsingDefaultShiftListToFile() throws Exception {
        final String fileName = TextFile.writeEncodedUsingDefaultShiftListToFile(FILENAME, text);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(text, Caesar.decodeList(result, TextFile.DEFAULT_SHIFT));
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