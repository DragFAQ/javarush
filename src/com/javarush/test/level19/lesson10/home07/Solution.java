package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 2)
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            String sCurrentLine;

            String outLine = "";
            while ((sCurrentLine = fileReader.readLine()) != null)
            {
                String[] words = sCurrentLine.split(" ");
                for (String s : words)
                    if (s.length() > 6)
                        outLine += s + " ";
            }
            fileReader.close();
            outLine = outLine.trim().replaceAll(" ", ",");

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
            fileWriter.write(outLine);
            fileWriter.close();
        }

    }
}
