package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            String name = "";
            switch (args[0])
            {
                case "-c":
                    for (int i = 1; i < args.length - 2; i++)
                        name += args[i] + " ";
                    createProduct(fileName, name.trim(), args[args.length - 2], args[args.length - 1]);
                    break;

            }
        }
    }

    private static void createProduct(String fileName, String productName, String price, String quantity) throws IOException
    {
        FileInputStream srcFile = new FileInputStream(fileName);
        byte[] buffer = new byte[srcFile.available()];
        if (srcFile.available() > 0)
            srcFile.read(buffer);

        srcFile.close();

        String strFile = new String(buffer);
        String[] lines = strFile.split("\n");

        int maxID = Integer.MIN_VALUE;
        for (String s : lines)
        {
            if (!(s.trim()).isEmpty())
            {
                int id = Integer.parseInt((s.substring(0, 8)).trim());
                maxID = id > maxID ? id : maxID;
            }
        }

        maxID ++;
        String addLine = String.format("%n%-8.8s%-30.30s%-8.8s%-4.4s", maxID, productName, price, quantity);
        FileWriter outFile = new FileWriter(fileName, true);
        outFile.append(addLine);
        outFile.close();
    }
}
