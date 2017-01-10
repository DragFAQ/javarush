package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> bytes = new HashMap<>();
        int maxDoubles = 0;

        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        while (file.available() > 0)
        {
            int data = file.read();
            int doubles = 1;

            if (bytes.containsKey(data))
                doubles += bytes.get(data);

            maxDoubles = doubles > maxDoubles ? doubles : maxDoubles;

            bytes.put(data, doubles);
        }

        file.close();

        String outStr = "";
        for (Map.Entry<Integer, Integer> pair: bytes.entrySet())
            if (pair.getValue() == maxDoubles)
                outStr += pair.getKey() + " ";

        System.out.println(outStr.trim());
    }
}
