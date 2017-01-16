package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(bufferedReader.readLine()));
        FileWriter writer = new FileWriter(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        bufferedReader.close();

        while (line != null)
        {
            sb.append(line + " ");
            line = br.readLine();
        }
        br.close();

        String[] words = sb.toString().split(" ");
        for (String word : words) {
            if (word.matches("\\d+"))
                writer.write(word + " ");
        }
        writer.close();
    }
}
