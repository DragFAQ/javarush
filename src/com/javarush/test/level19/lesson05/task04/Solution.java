package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bufferedReader.readLine());
        FileWriter writer = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();

        while (reader.ready())
        {
            int data = reader.read();
            if (data == 46)
                writer.write(33);
            else
                writer.write(data);
        }

        reader.close();
        writer.close();
    }
}
