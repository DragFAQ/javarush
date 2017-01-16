package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(bufferedReader.readLine()));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        bufferedReader.close();

        while (line != null)
        {
            sb.append(line + " ");
            line = br.readLine();
        }
        br.close();

        String fileStr = sb.toString().replaceAll("\\p{P}", " ");
        String[] array = fileStr.split(" ");

        int total = 0;
        for (String s : array)
            if (s.trim().equals("world"))
            total ++;

        System.out.println(total);
    }
}
