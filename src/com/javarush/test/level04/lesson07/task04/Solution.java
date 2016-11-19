package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int totalNeg = 0;

        if (a > 0)
            totalPos ++;
        if (b > 0)
            totalPos ++;
        if (c > 0)
            totalPos ++;

        if (a < 0)
            totalNeg ++;
        if (b < 0)
            totalNeg ++;
        if (c < 0)
            totalNeg ++;

        System.out.println("количество отрицательных чисел: " + totalNeg);
        System.out.println("количество положительных чисел: " + totalPos);
    }
}
