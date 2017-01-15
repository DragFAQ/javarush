package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 3)
        {
            switch (args[0])
            {
                case "-e":
                    xorFile(args[1], args[2]);
                    break;
                case "-d":
                    xorFile(args[1], args[2]);
                    break;
            }
        }
    }

    private static void xorFile(String fileName, String fileOutputName)
    {
        try
        {
            FileInputStream srcFile = new FileInputStream(fileName);
            FileOutputStream outFile = new FileOutputStream(fileOutputName);

            while (srcFile.available() > 0)
            {
                byte buffer = (byte)srcFile.read();
                buffer ^= 42;
                outFile.write(buffer);
            }

            srcFile.close();
            outFile.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
