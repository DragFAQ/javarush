package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i ++)
        {
            String tmp = reader.readLine();
            list.add(tmp);
            minLen = tmp.length() < minLen ? tmp.length() : minLen;
        }

        for (String s: list)
        {
            if (s.length() == minLen)
                System.out.println(s);
        }

    }
}
