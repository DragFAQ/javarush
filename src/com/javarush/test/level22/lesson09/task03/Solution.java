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
                {
                    String lastLetter = from.value.substring(from.value.length() - 1);
                    String firstLetter = to.value.substring(0, 1);
                    if (lastLetter.toUpperCase().equals(firstLetter.toUpperCase()))
                        from.children.add(to);
                }
                
        for (Word word : wordList)
            addChain(word, chainList, " " + word.value + " ", 1);

        int maxLevel = 0;
        String maxStr = "";
        for (Map.Entry<String, Integer> pair : chainList.entrySet())
        {
            if (pair.getValue() > maxLevel)
            {
                maxLevel = pair.getValue();
                maxStr = pair.getKey();
            }
        }

        result.append(maxStr.trim());

        return result;
    }

    private static void addChain(Word word, Map<String, Integer> chainList, String chain, int level)
    {
        boolean wasAdd = false;
        for (Word w : word.children)
            if (!chain.contains(" " + w.value + " "))
            {
                addChain(w, chainList, chain + w.value + " ", level + 1);
                wasAdd = true;
            }
        if (!wasAdd)
            chainList.put(chain, level);
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
