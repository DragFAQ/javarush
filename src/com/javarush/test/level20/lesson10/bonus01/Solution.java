package com.javarush.test.level20.lesson10.bonus01;

import java.util.Set;
import java.util.TreeSet;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        Set<Integer> list = new TreeSet<>();
        if (N > 0)
        {
            String tmp = Integer.toString(N);
            int digitsCount = 1;
            int[] numbers = new int[tmp.length()];
            for (int i = 0; i < numbers.length; i++)
                numbers[i] = 0;
            numbers[0] = 1;

            for (int currentNumber = 1; currentNumber <= N; currentNumber++)
            {
                long sum = 0;
                for (byte i = 0; i < digitsCount; i++)
                {
                    if (numbers[i] > 0)
                    {
                        long pow = 1;
                        for (byte j = 0; j < digitsCount; j++)
                        {
                            pow *= numbers[i];
                        }
                        sum += pow;
                    }
                }

                if (sum == currentNumber)
                    list.add(currentNumber);

                boolean isNeedUp;
                byte curDigit = 0;
                do
                {
                    if (numbers[curDigit] == 9)
                    {
                        numbers[curDigit] = 0;
                        curDigit++;
                        isNeedUp = true;
                    } else
                    {
                        numbers[curDigit]++;
                        isNeedUp = false;
                    }
                }
                while (isNeedUp);
                digitsCount = curDigit + 1 > digitsCount ? curDigit + 1 : digitsCount;
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (Integer l : list)
            result[i++] = l;

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = getNumbers(10000000);
        for (long i : nums)
            System.out.println(i);
    }
}
