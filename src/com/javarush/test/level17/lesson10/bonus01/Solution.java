package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String name = "";

        switch (args[0])
        {
            case "-c":
                for (int i = 1; i < args.length - 2; i++)
                    name += args[i] + " ";
                int id = createUser(name.trim(), args[args.length - 2], args[args.length - 1]);
                if (id > 0)
                    System.out.println(id);
                break;
            case "-u":
                for (int i = 2; i < args.length - 2; i++)
                    name += args[i] + " ";
                updateUser(args[1], name.trim(), args[args.length - 2], args[args.length - 1]);
                break;
            case "-d":
                deleteUser(args[1]);
                break;
            case "-i":
                String info;
                info = infoUser(args[1]);
                if (info != null)
                    System.out.println(info);
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
        } catch (NumberFormatException e)
        {
            return null;
        }

        if (userId >= 0 && userId < allPeople.size())
        {
            Person user = allPeople.get(userId);

            return  user.getName() + " " +
                    (user.getSex().equals(Sex.MALE) ?  "м" : "ж") + " " +
                    dateFormat.format(user.getBirthDay());
        }
        else
            return null;
    }

    private static void deleteUser(String id)
    {
        int userId;

        try
        {
            userId = Integer.parseInt(id);
        } catch (NumberFormatException e)
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
        } catch (NumberFormatException e)
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

        return allPeople.size() - 1;
    }
}
