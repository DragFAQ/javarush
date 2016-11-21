package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human fatherGrandFather = new Human("fatherGrandFather", true, 60, null, null);
        Human fatherGrandMother = new Human("fatherGrandMother", false, 60, null, null);
        Human motherGrandFather = new Human("motherGrandFather", true, 60, null, null);
        Human motherGrandMother = new Human("motherGrandMother", false, 60, null, null);

        Human father = new Human("father", true, 30, fatherGrandFather, fatherGrandMother);
        Human mother = new Human("mother", false, 30, motherGrandFather, motherGrandMother);

        Human son = new Human("son", true, 10, father, mother);
        Human dauther = new Human("dauther", false, 7, father, mother);
        Human baby = new Human("baby", true, 1, father, mother);

        System.out.println(fatherGrandFather);
        System.out.println(fatherGrandMother);
        System.out.println(motherGrandFather);
        System.out.println(motherGrandMother);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(son);
        System.out.println(dauther);
        System.out.println(baby);
    }

    public static class Human
    {
        //напишите тут ваш код
        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
