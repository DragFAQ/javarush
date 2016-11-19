package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String name;
    private int age;
    private int sex;

    //напишите тут ваш код
    public void initialize (String name)
    {
        this.name = name;
    }

    public void initialize (String name, int age)
    {
        this.age = age;
        initialize(name);
    }

    public void initialize (String name, int age, int sex)
    {
        this.sex = sex;
        initialize(name, age);
    }
}
