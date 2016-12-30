package com.javarush.test.level14.lesson08.home05;

public class Computer
{
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor)
    {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Monitor getMonitor()
    {

        return monitor;
    }

    public Mouse getMouse()
    {

        return mouse;
    }

    public Keyboard getKeyboard()
    {

        return keyboard;
    }
}
