package com.company.utils;

import java.util.ArrayList;

/**
 * Created by Yevgen on 25.01.2016 as a part of the project "Unit10_Homework".
 */
public class TextMessage {
    public final static String THEN_ENTER_EMPTY_ROW_WHEN_YOU_WANT_TO_STOP_INPUT_MESSAGE =
            "then enter empty row when you want to stop input";

    public static ArrayList readInputText(String Invitation) {
        ArrayList<String> arrayList = new ArrayList<>();
        String string;

        // Invitation to input
        Utils.printMessage(String.format("%s (%s):", Invitation, THEN_ENTER_EMPTY_ROW_WHEN_YOU_WANT_TO_STOP_INPUT_MESSAGE));
        // Input text until the "empty row"
        do {
            string = Utils.readInputString();
            if(string.isEmpty()) {
                break;
            }
            arrayList.add(string);
        } while (true);

        return arrayList;
    }

    public static ArrayList readNotEmptyInputText(String Invitation) {
        ArrayList<String> arrayList;

        do {
            arrayList = readInputText(Invitation);
        } while (arrayList.size() == 0);

        return arrayList;
    }
}
