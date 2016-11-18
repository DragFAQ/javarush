package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();

        list.add("qwe1");
        list.add("qwe2");
        list.add("qwe3");
        list.add("qwe4");
        list.add("qwe5");

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i ++)
            System.out.println(list.get(i));
    }
}
