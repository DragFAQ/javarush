package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

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
    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();

        for (long l = 1; l < N; l++)
        {
            String tmp = Long.toString(l);
            int digits = tmp.length();
            long sum = 0;
            for (int i = 0; i < digits; i++)
                sum += Math.pow(Integer.parseInt(tmp.substring(i, i + 1)), digits);

            if (sum == l)
                list.add(l);
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }

    public static void main(String[] args)
    {
        long[] nums = getNumbers(10);
        for (long i : nums)
            System.out.println(i);
    }
}
