package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(1d, "1");
        labels.put(11d, "11");
        labels.put(111d, "111");
        labels.put(1111d, "1111");
        labels.put(11111d, "11111");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
