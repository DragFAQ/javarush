package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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
        numString = reader.readLine();
        int c = Integer.parseInt(numString);

        int totalPos = 0;
        if (a > 0)
            totalPos ++;
        if (b > 0)
            totalPos ++;
        if (c > 0)
            totalPos ++;

        System.out.println(totalPos);
    }
}
