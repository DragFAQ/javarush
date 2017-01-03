package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(Object o1)
    {
    }

    private Solution(Object o1, Object o2)
    {
    }

    private Solution(Object o1, Object o2, Object o3)
    {
    }

    public Solution ()
    {

    }

    public Solution (Integer i1, Integer i2)
    {

    }

    public Solution (Integer i1, Integer i2, Integer i3)
    {

    }

    protected Solution (String s1)
    {

    }

    protected Solution (String s1, String s2)
    {

    }

    protected Solution (String s1, String s2, String s3)
    {

    }

    Solution (Boolean b1)
    {

    }

    Solution (Boolean b1, Boolean b2)
    {

    }

    Solution (Boolean b1, Boolean b2, Boolean b3)
    {

    }
}
