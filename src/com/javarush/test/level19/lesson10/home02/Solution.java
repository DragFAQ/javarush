package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            InputStream inStream = new FileInputStream(args[0]);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));
            String sCurrentLine;
            Map<String, Double> map = new TreeMap<>();
            Double maxVal = Double.MIN_VALUE;

            while ((sCurrentLine = fileReader.readLine()) != null)
            {
                String[] words = sCurrentLine.split(" ");
                if (words.length == 2)
                {
                    Double val = Double.parseDouble(words[1]);
                    String name = words[0];
                    val += map.get(name) == null ? 0 : map.get(name);
                    maxVal = val > maxVal ? val : maxVal;
                    map.put(name, val);
                }
            }
            fileReader.close();
            inStream.close();

            for (Map.Entry<String, Double> pair : map.entrySet())
                if (pair.getValue() == maxVal)
                    System.out.print(pair.getKey() + " ");
        }
    }
}
