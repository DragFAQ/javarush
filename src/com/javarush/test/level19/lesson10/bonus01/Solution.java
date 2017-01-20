package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> data1 = new ArrayList<>();
        ArrayList<String> data2 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String sCurrentLine;

        while ((sCurrentLine = file1.readLine()) != null)
            data1.add(sCurrentLine);
        while ((sCurrentLine = file2.readLine()) != null)
            data2.add(sCurrentLine);

        file1.close();
        file2.close();

        int idx1 = 0, idx2 = 0;
        while (idx1 < data1.size() || idx2 < data2.size())
        {
            if (idx1 < data1.size() && idx2 < data2.size() && data1.get(idx1).equals(data2.get(idx2)))
            {
                lines.add(new LineItem(Type.SAME, data1.get(idx1)));
                idx1++;
                idx2++;
            } else
            {
                if (idx1 >= data1.size())
                {
                    lines.add(new LineItem(Type.ADDED, data2.get(idx2)));
                    idx2++;
                } else if (idx2 >= data2.size())
                {
                    lines.add(new LineItem(Type.REMOVED, data1.get(idx1)));
                    idx1++;
                } else
                {
                    if (data1.get(idx1 + 1 < data1.size() ? idx1 + 1 : idx1).equals(data2.get(idx2)))
                    {
                        lines.add(new LineItem(Type.REMOVED, data1.get(idx1)));
                        idx1++;
                    } else
                    {
                        lines.add(new LineItem(Type.ADDED, data2.get(idx2)));
                        idx2++;
                    }
                }
            }
        }
    }

    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
