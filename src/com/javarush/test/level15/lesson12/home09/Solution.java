package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> params = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        try
        {
            String line = reader.readLine();
            if (!line.isEmpty())
            {
                int startPos = line.indexOf("?");
                line = line.substring(startPos + 1);
                String[] pairs = line.split("&");
                for (String pair : pairs)
                {
                    int idx = pair.indexOf("=");
                    if (idx > 0)
                    {
                        params.add(pair.substring(0, idx));
                        values.add(pair.substring(idx + 1));
                    } else
                    {
                        params.add(pair);
                        values.add("");
                    }
                }

                String outStr = "";
                for (String param : params)
                    outStr += param + " ";

                System.out.println(outStr.trim());

                for (int i = 0; i < params.size(); i++)
                {
                    if (params.get(i).equals("obj"))
                    {
                        String value = values.get(i);
                        try
                        {
                            alert(Double.parseDouble(value));
                        }
                        catch (NumberFormatException e)
                        {
                            alert(value);
                        }
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
