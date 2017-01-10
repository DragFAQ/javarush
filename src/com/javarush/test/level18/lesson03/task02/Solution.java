package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minByte = Integer.MAX_VALUE;

        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        while (file.available() > 0)
        {
            int data = file.read();
            minByte = data < minByte ? data : minByte;
        }

        file.close();

        System.out.println(minByte);
    }
}
