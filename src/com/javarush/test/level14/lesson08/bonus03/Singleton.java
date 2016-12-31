package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Drag on 31.12.2016.
 */
public class Singleton
{
    private static Singleton obj = null;

    private Singleton()
    {
    }

    static Singleton getInstance()
    {
        if (obj == null)
            obj = new Singleton();

        return obj;
    }
}
