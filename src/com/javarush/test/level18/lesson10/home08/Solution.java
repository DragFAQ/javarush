package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Thread> list = new ArrayList<>();

        while (true)
        {
            String fileName = reader.readLine();
            if (fileName.equals("exit"))
                break;
            Thread th = new ReadThread(fileName);
            list.add(th);
            th.start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try
            {
                FileInputStream file = new FileInputStream(fileName);

                resultMap.put(fileName, getMaxDoubledByte(file));

                file.close();
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

        private int getMaxDoubledByte (FileInputStream file) throws IOException
        {
            int result = -1;
            int[] array = new int[256];
            int maxDoubles = 0;

            while (file.available() > 0)
                array[file.read()] ++;

            for (int i = 0; i < 256; i++)
                if (array[i] > maxDoubles)
                {
                    result = i;
                    maxDoubles = array[i];
                }

            return result;
        }
    }
}
