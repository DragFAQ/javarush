package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
            String sCurrentLine, allFile = "";
            while ((sCurrentLine = fileReader.readLine()) != null)
                allFile += sCurrentLine + "\n";
            Map<Integer, String> map = new TreeMap<>();

            Pattern p = Pattern.compile("<\\/?" + args[0] + "[^>]*>");
            Matcher m = p.matcher(allFile);
            Stack<Integer> tags = new Stack<>();
            while (m.find())
            {
                if (allFile.substring(m.start() + 1, m.start() + 2).equals("/"))
                {
                    int i = tags.pop();
                    map.put(i, allFile.substring(i, m.end()));
                }
                else
                    tags.push(m.start());
            }

            for (Map.Entry<Integer, String> pair : map.entrySet())
                System.out.println(pair.getValue());
        }
    }
}
