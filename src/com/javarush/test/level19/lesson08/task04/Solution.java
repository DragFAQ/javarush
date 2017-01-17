package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        StringBuilder stringBuilder = new StringBuilder(result);
        String reverseString = stringBuilder.toString().trim() + " ";

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(reverseString);
        int firstNum = 0, secNum = 0;
        if (m.find())
            firstNum = Integer.parseInt(reverseString.substring(m.start(), m.end()));
        if (m.find())
            secNum = Integer.parseInt(reverseString.substring(m.start(), m.end()));

        p = Pattern.compile("[+|*|-]");
        m = p.matcher(reverseString);
        if (m.find())
        {
            String symb = reverseString.substring(m.start(), m.end());

            switch (symb)
            {
                case "-":
                    reverseString += firstNum - secNum;
                    break;
                case "+":
                    reverseString += firstNum + secNum;
                    break;
                case "*":
                    reverseString += firstNum * secNum;
                    break;
            }

            System.out.println(reverseString);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

