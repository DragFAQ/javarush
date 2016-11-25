package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] result = new ArrayList[3];

        result[0] = new ArrayList<String>();
        result[0].add("111");
        result[0].add("222");
        result[0].add("333");
        result[1] = new ArrayList<String>();
        result[1].add("111");
        result[1].add("222");
        result[1].add("333");
        result[2] = new ArrayList<String>();
        result[2].add("111");
        result[2].add("222");
        result[2].add("333");

        return result;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}