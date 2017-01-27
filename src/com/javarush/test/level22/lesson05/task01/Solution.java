package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        int first = 0;
        int last = 0;
        int spaces = 0;

        if (string == null)
            throw new TooShortStringException();

        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == ' ')
            {
                spaces++;
                if (spaces == 1)
                    first = i + 1;
                else if (spaces == 5)
                    last = i;
            }
        }
        if (last == 0)
            last = string.length();

        if (first == 0 || spaces < 4 || last == 0)
            throw new TooShortStringException();

        return string.substring(first, last);
    }

    public static class TooShortStringException extends Throwable
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
