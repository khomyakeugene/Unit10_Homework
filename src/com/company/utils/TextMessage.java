package com.company.utils;

import java.util.ArrayList;

/**
 * Created by Yevgen on 25.01.2016 as a part of the project "Unit10_Homework".
 */
public class TextMessage {
    public final static String THEN_ENTER_EMPTY_ROW_WHEN_YOU_WANT_TO_STOP_INPUT_MESSAGE =
            "then enter empty row when you want to stop input";

    public static ArrayList<String> readInputText(String invitation) {
        ArrayList<String> arrayList = new ArrayList<>();

        // Invitation to input
        Utils.printMessage(String.format("%s (%s):", invitation, THEN_ENTER_EMPTY_ROW_WHEN_YOU_WANT_TO_STOP_INPUT_MESSAGE));
        // Input text until the "empty row"
        String string;
        do {
            string = Utils.readInputString();
            if(string.isEmpty()) {
                break;
            }
            arrayList.add(string);
        } while (true);

        return arrayList;
    }

    public static ArrayList<String> readNotEmptyInputText(String invitation) {
        ArrayList<String> arrayList;

        do {
            arrayList = readInputText(invitation);
        } while (arrayList.size() == 0);

        return arrayList;
    }
}
