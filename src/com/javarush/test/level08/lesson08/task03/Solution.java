package com.javarush.test.level08.lesson08.task03;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++)
            map.put("Фамилия" + i, "Имя" + (new Random()).nextInt(4));

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int result = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (name.equals(pair.getValue()))
                result++;
        }

        return result;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int result = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (lastName.equals(pair.getKey()))
                result++;
        }

        return result;
    }
}
