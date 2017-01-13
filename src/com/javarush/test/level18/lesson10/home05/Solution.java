package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import sun.reflect.generics.tree.ByteSignature;
import sun.reflect.generics.tree.DoubleSignature;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        reader.close();

        String number = "";
        ArrayList<Double> list = new ArrayList<>();

        while (file1.available() > 0)
        {
            int symb = file1.read();
            if (symb == Integer.valueOf(' '))
            {
                if (!number.trim().equals(""))
                    list.add(Double.parseDouble(number.trim()));
                number = "";
            }
            else
                number += (char) symb;
        }
        if (!number.trim().equals(""))
            list.add(Double.parseDouble(number.trim()));

        for (Double d : list)
            file2.write((Math.round(d) + " ").getBytes());

        file1.close();
        file2.close();
    }
}
