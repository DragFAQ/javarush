package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код
        Cat tomCat = new Cat("Tom", 100, "gray");
        Dog spikeDog = new Dog("Spike", 40, 30);

    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
    public static class Dog
    {
        String name;
        int weight;
        int teeth;

        public Dog(String name, int weight, int teeth)
        {
            this.name = name;
            this.weight = weight;
            this.teeth = teeth;
        }
    }

    public static class Cat
    {
        String name;
        int speed;
        String color;

        public Cat(String name, int speed, String color)
        {
            this.name = name;
            this.speed = speed;
            this.color = color;
        }
    }
}