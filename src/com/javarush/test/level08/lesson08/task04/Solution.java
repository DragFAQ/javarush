package com.javarush.test.level08.lesson08.task04;

import sun.applet.Main;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Stallone1", new Date("JUNE 10 1980"));
        map.put("Stallone2", new Date("JUNE 10 1980"));
        map.put("Stallone3", new Date("JULY 10 1980"));
        map.put("Stallone4", new Date("MARCH 10 1980"));
        map.put("Stallone5", new Date("APRIL 10 1980"));
        map.put("Stallone6", new Date("MAY 10 1980"));
        map.put("Stallone7", new Date("AUGUST 10 1980"));
        map.put("Stallone8", new Date("SEPTEMBER 10 1980"));
        map.put("Stallone9", new Date("OCTOBER 10 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Set<Integer> summer = new HashSet<Integer>(Arrays.asList(5, 6, 7));
        Iterator<Map.Entry<String, Date>> itr = map.entrySet().iterator();

        while (itr.hasNext())
        {
            if (summer.contains(itr.next().getValue().getMonth()))
                itr.remove();
        }
    }

    public static void main(String[] args)
    {
        removeAllSummerPeople(createMap());
    }
}
