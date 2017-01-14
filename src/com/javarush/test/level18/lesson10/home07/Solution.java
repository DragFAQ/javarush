package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file = new FileInputStream(reader.readLine());
            reader.close();

            byte[] buffer = new byte[file.available()];
            if (file.available() > 0)
                file.read(buffer);

            String strFile = new String(buffer);
            String[] lines = strFile.split("\n");

            for (String s : lines)
                if (s.indexOf(args[0] + " ") == 0)
                {
                    System.out.println(s);
                    break;
                }

            file.close();
        }
    }
}
