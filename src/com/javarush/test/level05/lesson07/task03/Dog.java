package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    String name;
    int height;
    String color;

    public void initialize (String name)
    {
        this.name = name;
    }

    public void initialize (String name, int height)
    {
        this.height = height;
        initialize(name);
    }
    public void initialize (String name, int height, String color)
    {
        this.color = color;
        initialize(name, height);
    }
}
