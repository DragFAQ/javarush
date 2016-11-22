package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> tmpMap = new HashMap<>();
        tmpMap.putAll(map);

        Iterator<Map.Entry<String, String>> itr = tmpMap.entrySet().iterator();
        while (itr.hasNext())
        {
            String tmpName = itr.next().getValue();
            itr.remove();
            if (tmpMap.containsValue(tmpName))
                removeItemFromMapByValue(map, tmpName);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args)
    {
        removeTheFirstNameDuplicates(createMap());
    }
}
