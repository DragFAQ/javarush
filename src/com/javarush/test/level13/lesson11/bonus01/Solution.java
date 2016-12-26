package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(reader.readLine());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));
        ArrayList<Integer> list = new ArrayList<>();
        String sCurrentLine;

        while ((sCurrentLine = fileReader.readLine()) != null)
        {
            int data = Integer.parseInt(sCurrentLine);
            if (data % 2 == 0)
                list.add(data);
        }

        inStream.close();

        Integer[] array = list.toArray(new Integer[0]);

        boolean flag = true;
        while (flag)
        {
            flag = false;
            for (int i = 1; i < array.length; i++)
                if (array[i] < array[i - 1])
                {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    flag = true;
                }
        }

        for (Integer i : array)
            System.out.println(i);
    }
}
