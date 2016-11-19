package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "z1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "z2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "z3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "z4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "z5";
        Zerg zerg6 = new Zerg();
        zerg6.name = "z6";
        Zerg zerg7 = new Zerg();
        zerg7.name = "z7";
        Zerg zerg8 = new Zerg();
        zerg8.name = "z8";
        Zerg zerg9 = new Zerg();
        zerg9.name = "z9";
        Zerg zerg10 = new Zerg();
        zerg10.name = "z10";

        Protos protos1 = new Protos();
        protos1.name = "p1";
        Protos protos2 = new Protos();
        protos2.name = "p2";
        Protos protos3 = new Protos();
        protos3.name = "p3";
        Protos protos4 = new Protos();
        protos4.name = "p4";
        Protos protos5 = new Protos();
        protos5.name = "p5";

        Terran terran1 = new Terran();
        terran1.name = "t1";
        Terran terran2 = new Terran();
        terran2.name = "t2";
        Terran terran3 = new Terran();
        terran3.name = "t3";
        Terran terran4 = new Terran();
        terran4.name = "t4";
        Terran terran5 = new Terran();
        terran5.name = "t5";
        Terran terran6 = new Terran();
        terran6.name = "t6";
        Terran terran7 = new Terran();
        terran7.name = "t7";
        Terran terran8 = new Terran();
        terran8.name = "t8";
        Terran terran9 = new Terran();
        terran9.name = "t9";
        Terran terran10 = new Terran();
        terran10.name = "t10";
        Terran terran11 = new Terran();
        terran10.name = "t11";
        Terran terran12 = new Terran();
        terran10.name = "t12";
    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}