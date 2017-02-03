package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();
            String sCurrentLine;

            while ((sCurrentLine = fileReader.readLine()) != null)
            {
                String[] words = sCurrentLine.split(" ");
                for (String s : words)
                    if (!s.isEmpty())
                        list.add(s);
            }

            fileReader.close();
        } catch (IOException e)
        {

        }

        String[] array = new String[list.size()];
        array = list.toArray(array);
        StringBuilder result = getLine(array);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> chainList = new HashMap<>();
        ArrayList<Word> wordList = new ArrayList<>();

        for (String s : words)
            wordList.add(new Word(s));

        for (Word from : wordList)
            for (Word to : wordList)
                if (from != to)
                    ;

        return result;
    }

    private static ArrayList<Integer> getWordIndexByFirstLetter (String[] array, String letter)
    {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
            if (letter.toUpperCase().equals(array[i].substring(0, 1).toUpperCase()))
                result.add(i);

        return result;
    }

    static class Word
    {
        public String value;
        public ArrayList<Word> children = new ArrayList<>();

        public Word(String value)
        {
            this.value = value;
        }
    }
}
