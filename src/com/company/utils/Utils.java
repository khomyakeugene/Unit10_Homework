package com.company.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * Created by Yevgen on 06.01.2016.
 */

public class Utils {
    public final static String PLEASE_REPEAT_ENTER =
            "{0} was generated with data \"{1}\". Please, repeat enter action";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String readInputString() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                printMessage(MessageFormat.format(PLEASE_REPEAT_ENTER, e.getClass().getName(), e.getMessage()));
            }
        } while (true);
    }


    public static String readInputString(String invitation) {
        printMessage(invitation);
        return readInputString();
    }

    public static String readNotInputInputString(String invitation) {
        String string;

        do {
            string = readInputString(invitation);
        } while (string.isEmpty());

        return string;
    }

    public static String repeatString(String string, int times) {
        // Some variant BEFORE Java 8 - store here just as an example of an alternative way
        // return String.format(String.format("%%%ds", times), "").replace(" ", string);
        return String.join("", java.util.Collections.nCopies(times, string));
    }

    public static String repeatChar(Character character, int times) {
        return repeatString(character.toString(), times);
    }

    public static String stringStart(String string, int length) {
        return (string.length() > length) ? string.substring(0, length) : string;
    }
}