package com.company.utils;

import java.util.AbstractCollection;

/**
 * Created by Yevgen on 17.01.2016 as a part of the project "Unit8_Homework".
 */
public class Collections {
    public static void printList(AbstractCollection list) {
        list
                .stream()
                .forEach(p -> Utils.printMessage(p.toString()));
    }
}
