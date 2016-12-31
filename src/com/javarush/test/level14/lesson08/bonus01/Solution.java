package com.javarush.test.level14.lesson08.bonus01;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] m = new int[2];
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }

        try
        {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
        } catch (IndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new CharConversionException();
        } catch (CharConversionException e)
        {
            exceptions.add(e);
        }


        try
        {
            throw new FileSystemException("");
        } catch (FileSystemException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IOException();
        } catch (IOException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new FileNotFoundException("");
        } catch (FileNotFoundException e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new SQLException("");
        } catch (SQLException e)
        {
            exceptions.add(e);
        }
    }
}
