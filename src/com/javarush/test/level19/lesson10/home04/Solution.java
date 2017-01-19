package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.*;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String sCurrentLine;

        while ((sCurrentLine = fileReader.readLine()) != null)
        {
            String[] lineWords = sCurrentLine.split(" ");
            int duplicates = 0;
            for (int i = 0; i < words.size(); i++)
                for (int j = 0; j < lineWords.length; j++)
                    if (words.get(i).equals(lineWords[j]))
                        duplicates++;

            if (duplicates == 2)
                System.out.println(sCurrentLine);
        }
        fileReader.close();
    }
}
