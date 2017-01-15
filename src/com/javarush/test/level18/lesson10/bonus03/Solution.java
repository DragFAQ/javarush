package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            String name = "";
            switch (args[0])
            {
                case "-u":
                    for (int i = 2; i < args.length - 2; i++)
                        name += args[i] + " ";
                    updateProduct(fileName, args[1], name.trim(), args[args.length - 2], args[args.length - 1]);
                    break;
                case "-d":
                    deleteProduct(fileName, args[1]);
                    break;
            }
        }
    }

    private static void deleteProduct(String fileName, String id) throws IOException
    {
        ArrayList<String> fileContent = readFile(fileName);
        int delIdx = -1;
        for (int i = 0; i < fileContent.size(); i++)
        {
            if (!(fileContent.get(i).trim()).isEmpty())
            {
                if (id.equals((fileContent.get(i).substring(0, 8)).trim()))
                {
                    delIdx = i;
                    break;
                }
            }
        }

        if (delIdx != -1)
            fileContent.remove(delIdx);

        FileWriter outFile = new FileWriter(fileName);
        outFile.write(fileContent.toString());
        outFile.close();
    }

    private static void updateProduct(String fileName, String id, String productName, String price, String quantity) throws IOException
    {
        //String[] fileContent = readFile(fileName);
    }

    private static ArrayList<String> readFile(String fileName) throws IOException
    {
        FileInputStream srcFile = new FileInputStream(fileName);
        byte[] buffer = new byte[srcFile.available()];
        if (srcFile.available() > 0)
            srcFile.read(buffer);

        srcFile.close();
        String[] list = (new String(buffer)).split("\n");

        return (ArrayList<String>) Arrays.asList(list);
    }
}
