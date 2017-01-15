package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> list = new TreeSet<>();
        String outFileName = "";
        Pattern p = Pattern.compile("\\d+$");

        while (true)
        {
            String fileName = reader.readLine();
            if (fileName.equals("end"))
                break;
            if (outFileName.isEmpty())
                outFileName = fileName.replaceFirst("\\.part\\d+$", "");
            Matcher m = p.matcher(fileName);
            if (m.find())
                list.add(Integer.parseInt(fileName.substring(m.start(), m.end())));
        }
        reader.close();

        if (!outFileName.isEmpty())
        {
            FileOutputStream outFile = new FileOutputStream(outFileName);

            for (Integer i : list)
            {
                FileInputStream srcFile = new FileInputStream(outFileName + ".part" + i);

                while (srcFile.available() > 0)
                {
                    int data = srcFile.read();
                    outFile.write(data);
                }

                srcFile.close();
            }
            outFile.close();
        }
    }
}
