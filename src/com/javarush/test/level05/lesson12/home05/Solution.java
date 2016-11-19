package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        //напишите тут ваш код
        int sum = 0;
        String str = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        str = reader.readLine();
        while (!str.equals("сумма"))
        {
            int a = Integer.parseInt(str);
            sum += a;
            str = reader.readLine();
        }
        System.out.println(sum);
    }
}
