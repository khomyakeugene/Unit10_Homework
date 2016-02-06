package com.company.utils;

import org.junit.Assert;
import java.util.ArrayList;

/**
 * Created by Yevgen on 06.02.2016 as a part of the project "Unit9_Homework".
 */
public class TestUtil {
    public static void assertArrayListEquals(ArrayList<? extends Object> expected, ArrayList<? extends Object> actual) {
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
