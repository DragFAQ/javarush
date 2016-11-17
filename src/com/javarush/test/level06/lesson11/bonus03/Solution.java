package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int cntNumbers = 5;
        int[] nums = new int[cntNumbers];

        for (int i = 0; i < cntNumbers; i++)
            nums[i] = Integer.parseInt(reader.readLine());

        boolean flag;

        do
        {
            flag = false;

            for (int i = 0; i < cntNumbers - 1; i++)
            {
                if (nums[i] > nums[i + 1])
                {
                    int tmpNum = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmpNum;
                    flag = true;
                }
            }
        }
        while (flag);

        for (int i = 0; i < cntNumbers; i++)
            System.out.println(nums[i]);
    }
}
