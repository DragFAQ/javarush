package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> bytes = new ArrayList<>();

        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        while (file.available() > 0)
        {
            int data = file.read();
            if (!bytes.contains(data))
                bytes.add(data);
        }

        file.close();

        Collections.sort(bytes);

        String result = "";

        for (Integer i: bytes)
            result += i + " ";

        System.out.println(result.trim());
    }
}
