package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String numString = reader.readLine();
        int a = Integer.parseInt(numString);
        numString = reader.readLine();
        int b = Integer.parseInt(numString);

        if (a < b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}