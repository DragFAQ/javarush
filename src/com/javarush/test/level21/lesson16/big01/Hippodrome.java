package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        game.getHorses().add(new Horse("First", 3, 0));
        game.getHorses().add(new Horse("Second", 3, 0));
        game.getHorses().add(new Horse("Third", 3, 0));

        game.run();
        game.printWinner();
    }

    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run () throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(50);
        }
    }

    public void move ()
    {
        for (Horse horse : horses)
            horse.move();
    }

    public void print ()
    {
        for (Horse horse : horses)
            horse.print();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        Horse result = null;
        double maxDistance = 0;

        for (Horse horse : horses)
            if (horse.getDistance() > maxDistance)
            {
                result = horse;
                maxDistance = horse.getDistance();
            }

        return result;
    }

    public void printWinner ()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
