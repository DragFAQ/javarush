package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        String body;
        int height;
        int weight;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, String body)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.body = body;
        }

        public Human(String name, int age, boolean sex, String body, int height)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.body = body;
            this.height = height;
        }

        public Human(String name, int age, boolean sex, String body, int height, int weight)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.body = body;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String body, int height, int weight)
        {
            this.name = name;
            this.body = body;
            this.height = height;
            this.weight = weight;
        }

        public Human(int age, String body, int weight, int height)
        {
            this.age = age;
            this.body = body;
            this.weight = weight;
            this.height = height;
        }

        public Human(String body, int height, int weight)
        {
            this.body = body;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }
    }
}
