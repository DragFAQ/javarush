package com.javarush.test.level20.lesson10.bonus01;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.math.BigInteger;
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
    public static long[] getNumbers(long N) {
        Set<Long> list = new TreeSet<>();
        if (N > 0)
        {
            int curNum = 1;

            BigInteger sum = BigInteger.ONE;
            while (sum.compareTo(BigInteger.valueOf(N)) == -1)
            {
                list.add(sum.longValue());
                curNum++;
                String tmp = Integer.toString(curNum);
                int digits = tmp.length();
                sum = BigInteger.ZERO;
                for (int i = 0; i < digits; i++)
                    sum = sum.add(BigInteger.valueOf((long) Math.pow(Integer.parseInt(tmp.substring(i, i + 1)), digits)));
            }
        }
        /*if (N > 0)
        {
            BigInteger sum = new BigInteger("1");
            while (sum.compareTo(BigInteger.valueOf(N)) == 1)
            {
                list.add(sum.longValue());
                sum = BigInteger.ZERO;
                for (int digits = 1; digits < 21; digits++)
                {
                    for (int curDig = 1; curDig <= digits; curDig++)
                    {
                        for (int nums = 0; nums <= 9; nums++)
                        {
                            sum.add(BigInteger.valueOf(Match.pow(nums, digits)));
                        }
                    }
                }
            }
        }*/
       /* for (long l = 1; l < N; l++)
        {
            String tmp = Long.toString(l);
            int digits = tmp.length();
            long sum = 0;
            for (int i = 0; i < digits; i++)
                sum += Math.pow(Integer.parseInt(tmp.substring(i, i + 1)), digits);

            if (sum == l)
                list.add(l);
        }
*/
        long[] result = new long[list.size()];
        int i = 0;
        for (Long l : list)
            result[i++] = l;

        return result;
    }

    public static void main(String[] args)
    {
        long[] nums = getNumbers(9223372036854775806l);
        for (long i : nums)
            System.out.println(i);
    }
}
