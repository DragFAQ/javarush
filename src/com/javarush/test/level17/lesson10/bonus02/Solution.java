package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        //start here - начни тут
        String name = "";
        if (args.length > 0)
            switch (args[0])
            {
                case "-c":
                    for (int i = 1; i < args.length; i += 3)
                    {
                        int id = createUser(args[i], args[i + 1], args[i + 2]);
                        if (id > 0)
                            System.out.println(id);
                    }
                    break;
                case "-u":
                    for (int i = 1; i < args.length; i += 4)
                        updateUser(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    break;
                case "-d":
                    for (int i = 1; i < args.length; i++)
                        deleteUser(args[i]);
                    break;
                case "-i":
                    String info;
                    for (int i = 1; i < args.length; i++)
                    {
                        info = infoUser(args[i]);
                        if (info != null)
                            System.out.println(info);
                    }
                    break;
            }
    }

    private static String infoUser(String id)
    {
        int userId;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        try
        {
            userId = Integer.parseInt(id);
        }
        catch (NumberFormatException e)
        {
            return null;
        }

        if (userId >= 0 && userId < allPeople.size())
        {
            Person user = allPeople.get(userId);

            if (user.getBirthDay() == null)
                return null;
            else
                return user.getName() + " " +
                        (user.getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                        dateFormat.format(user.getBirthDay());
        } else
            return null;
    }

    private static void deleteUser(String id)
    {
        int userId;

        try
        {
            userId = Integer.parseInt(id);
        }
        catch (NumberFormatException e)
        {
            return;
        }

        if (userId >= 0 && userId < allPeople.size())
        {
            Person user = allPeople.get(userId);

            user.setName(null);
            user.setSex(null);
            user.setBirthDay(null);
        }
    }

    private static void updateUser(String id, String name, String sex, String bd)
    {
        int userId;
        Sex userSex;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date birthDate;

        try
        {
            userId = Integer.parseInt(id);
        }
        catch (NumberFormatException e)
        {
            return;
        }

        switch (sex)
        {
            case "м":
                userSex = Sex.MALE;
                break;
            case "ж":
                userSex = Sex.FEMALE;
                break;
            default:
                return;
        }

        try
        {
            birthDate = dateFormat.parse(bd);
        }
        catch (ParseException e)
        {
            return;
        }

        if (userId >= 0 && userId < allPeople.size())
        {
            Person user = allPeople.get(userId);
            user.setName(name);
            user.setSex(userSex);
            user.setBirthDay(birthDate);
        }
    }

    private static int createUser(String name, String sex, String bd)
    {
        boolean male;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date birthDate;

        switch (sex)
        {
            case "м":
                male = true;
                break;
            case "ж":
                male = false;
                break;
            default:
                return -1;
        }

        try
        {
            birthDate = dateFormat.parse(bd);
        }
        catch (ParseException e)
        {
            return -2;
        }

        if (male)
            allPeople.add(Person.createMale(name, birthDate));
        else
            allPeople.add(Person.createFemale(name, birthDate));

        return allPeople.size() - 1;
    }
}
