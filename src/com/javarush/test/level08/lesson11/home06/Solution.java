package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> kids = new ArrayList<>();
        ArrayList<Human> fatherRelatives = new ArrayList<>();
        ArrayList<Human> motherRelatives = new ArrayList<>();
        ArrayList<Human> grandParents = new ArrayList<>();

        kids.add(new Human("son", true, 10, null));
        kids.add(new Human("daughter", false, 7, null));
        kids.add(new Human("baby", true, 1, null));

        fatherRelatives.add(new Human("father", true, 30, kids));
        motherRelatives.add(new Human("mother", false, 30, kids));

        grandParents.add(new Human("fatherGrandFather", true, 60, fatherRelatives));
        grandParents.add(new Human("fatherGrandMother", false, 60, fatherRelatives));
        grandParents.add(new Human("motherGrandFather", true, 60, motherRelatives));
        grandParents.add(new Human("motherGrandMother", false, 60, motherRelatives));

        for (Human h : grandParents)
            System.out.println(h);

        for (Human h : fatherRelatives)
            System.out.println(h);

        for (Human h : motherRelatives)
            System.out.println(h);

        for (Human h : kids)
            System.out.println(h);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children != null)
            {
                int childCount = this.children.size();
                if (childCount > 0)
                {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }

            return text;
        }
    }

}
