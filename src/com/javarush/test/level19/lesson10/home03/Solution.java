package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            InputStream inStream = new FileInputStream(args[0]);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inStream));
            String sCurrentLine;

            while ((sCurrentLine = fileReader.readLine()) != null)
            {
                String[] words = sCurrentLine.split(" ");
                if (words.length > 3)
                {
                    String name = "";
                    for (int i = 0; i < words.length - 3; i++)
                        name += words[i] + " ";

                    Calendar calendar = new GregorianCalendar(Integer.parseInt(words[words.length - 1]),
                            Integer.parseInt(words[words.length - 2]) - 1, Integer.parseInt(words[words.length - 3]));
                    Date birthDate = calendar.getTime();

                    PEOPLE.add(new Person(name.trim(), birthDate));
                }
            }
            fileReader.close();
            inStream.close();
        }
    }
}
