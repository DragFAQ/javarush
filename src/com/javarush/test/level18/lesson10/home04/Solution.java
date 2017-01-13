package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file1 = new FileInputStream(fileName);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        reader.close();

        byte[] buffer1 = new byte[file2.available()];
        if (file2.available() > 0)
            file2.read(buffer1, 0, file2.available());

        byte[] buffer2 = new byte[file1.available()];
        if (file1.available() > 0)
            file1.read(buffer2, 0, file1.available());

        file1.close();
        file2.close();

        FileOutputStream file3 = new FileOutputStream(fileName);
        file3.write(buffer1);
        file3.write(buffer2);

        file3.close();
    }
}
