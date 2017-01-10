package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> bytes = new HashMap<>();
        int minDoubles = Integer.MAX_VALUE;

        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        while (file.available() > 0)
        {
            int data = file.read();
            int doubles = 1;

            if (bytes.containsKey(data))
                doubles += bytes.get(data);

            bytes.put(data, doubles);
        }

        file.close();

        for (Map.Entry<Integer, Integer> pair: bytes.entrySet())
            minDoubles = pair.getValue() < minDoubles ? pair.getValue() : minDoubles;

        String outStr = "";
        for (Map.Entry<Integer, Integer> pair: bytes.entrySet())
            if (pair.getValue() == minDoubles)
                outStr += pair.getKey() + " ";

        System.out.println(outStr.trim());

    }
}
