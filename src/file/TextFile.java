package file;

import com.company.utils.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yevgen on 25.01.2016 as a part of the project "Unit10_Homework".
 */
public class TextFile {
    public final static String CANNOT_OPEN_FILE_TO_WRITE_PATTERN = "Cannot open file \"%s\" to write!";
    public final static String CANNOT_CLOSE_FILE_PATTERN = "Cannot close file \"%s\"!";
    public final static String CANNOT_WRITE_ROW_TO_FILE_PATTERN = "Cannot write row \"%s\" to file \"%s\"!";

    public static void writeListToFile(String fileName, List list) {
        BufferedWriter bufferedWriter = null;
        String string;

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
                for (Object object : list) {
                    string = object.toString();
                    try {
                        bufferedWriter.write(string);
                        bufferedWriter.newLine();
                    } catch (IOException e) {
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
                    Utils.printMessage(String.format(CANNOT_CLOSE_FILE_PATTERN, fileName));
                    Utils.printMessage(e.getMessage());
                }
            }
        }
    }

    // Return absolute path as a sign that file has been successfully saved
}