package com.company.file;

import com.company.caesar.Caesar;
import com.company.utils.TestUtil;
import org.junit.AfterClass;
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

    static private String readingPlainTextFileName = "plain_read.txt";//порядок ключевых слов - модификаторов private static
    static private String readingCodeTextFileName = "code_read.txt";
    static private String readingDefaultCodeTextFileName = "code_default_read.txt";
    static private String writingFileName = "write.txt";
    private static ArrayList<String> writingText;
    private static ArrayList<String> readingText;

    private static void prepareTestDataForWriting() { //и все-таки приватные методы пишутся ниже вызывающего их метода.
        writingText = new ArrayList<>();
        writingText.add("This is an example");
        writingText.add("of a file writing");
    }

    private static void prepareTestDataForReading() {
        readingText = new ArrayList<>();
        readingText.add("This is an example");
        readingText.add("of a file reading");

        readingPlainTextFileName = TestUtil.saveToFile(readingPlainTextFileName, readingText);
        readingCodeTextFileName =
                TestUtil.saveToFile(readingCodeTextFileName, Caesar.encodeList(readingText, DEFAULT_SHIFT));
        readingDefaultCodeTextFileName =
                TestUtil.saveToFile(readingDefaultCodeTextFileName, Caesar.encodeList(readingText, TextFile.DEFAULT_SHIFT));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        prepareTestDataForWriting();
        prepareTestDataForReading();
    }

    @AfterClass //этот метод пишется после всех тестовых методов
    public static void tearDownClass() throws Exception {
        TestUtil.deleteFile(writingFileName);
        TestUtil.deleteFile(readingPlainTextFileName);
        TestUtil.deleteFile(readingCodeTextFileName);
        TestUtil.deleteFile(readingDefaultCodeTextFileName);
    }

    @Test  (timeout = 1000)
    public void testGetAbsoluteFileName() throws Exception {
        final String result = TextFile.getAbsoluteFileName(writingFileName);//глаза режет. Мы в ассерте вызываем сначала
        //expected, потом result. В такой же последовательности хочется и подготавливать переменные с данными.

        final String expected = new File(writingFileName).getAbsolutePath();
        assertEquals(expected, result);
    }

    @Test  (timeout = 1000)
    public void testWriteListToFile() throws Exception {
        final String fileName = TextFile.writeListToFile(writingFileName, writingText);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(writingText, result);
    }


    @Test  (timeout = 1000)
    public void testWriteEncodedListToFile() throws Exception {
        final String fileName = TextFile.writeEncodedListToFile(writingFileName, writingText, DEFAULT_SHIFT);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(writingText, Caesar.decodeList(result, DEFAULT_SHIFT));
    }

    @Test  (timeout = 1000)
    public void testWriteEncodedUsingDefaultShiftListToFile() throws Exception {
        final String fileName = TextFile.writeEncodedUsingDefaultShiftListToFile(writingFileName, writingText);

        ArrayList<String> result = TestUtil.readFromFile(fileName);
        assertArrayListEquals(writingText, Caesar.decodeList(result, TextFile.DEFAULT_SHIFT));
    }

    @Test  (timeout = 1000)
    public void testReadListFromFile() throws Exception {
        ArrayList<String> result = TextFile.readListFromFile(readingPlainTextFileName);

        assertArrayListEquals(readingText, result);
    }

    @Test  (timeout = 1000)
    public void testReadDecodedListFromFile() throws Exception {
        ArrayList<String> result = TextFile.readDecodedListFromFile(readingCodeTextFileName, DEFAULT_SHIFT);

        assertArrayListEquals(readingText, result);
    }

    @Test  (timeout = 1000)
    public void testReadDecodedUsingDefaultShiftListToFile() throws Exception {
        ArrayList<String> result = TextFile.readDecodedUsingDefaultShiftListToFile(readingDefaultCodeTextFileName);

        assertArrayListEquals(readingText, result);
    }
}