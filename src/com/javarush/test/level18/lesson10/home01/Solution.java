package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            FileInputStream file = new FileInputStream(args[0]);
            int count = 0;

            while (file.available() > 0)
            {
                int i = file.read();
                if (    (i >= Integer.valueOf('A') && i <= Integer.valueOf('Z')) ||
                        (i >= Integer.valueOf('a') && i <= Integer.valueOf('z')))
                    count ++;
            }

            System.out.println(count);

            file.close();
        }
    }
}
