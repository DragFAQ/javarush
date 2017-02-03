package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String sCurrentLine;
        ArrayList<String> list = new ArrayList<>();

        while ((sCurrentLine = fileReader.readLine()) != null)
        {
            String[] words = sCurrentLine.split(" ");
            for (String word : words)
            {
                boolean isFound = false;
                int i;
                for (i = 0; i < list.size(); i++)
                {
                    StringBuilder b = new StringBuilder(list.get(i));
                    if (word.equals(b.reverse().toString()))
                    {
                        isFound = true;
                        break;
                    }
                }
                if (isFound)
                {
                    Pair p = new Pair();
                    p.first = word;
                    p.second = list.get(i);
                    result.add(p);
                    list.remove(i);
                } else
                    list.add(word);
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
