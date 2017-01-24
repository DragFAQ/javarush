package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        ArrayList<Byte[][]> list = new ArrayList<>();

        if (a.length > 0 && a[0].length > 0)
        {
            for (int x = 0; x < a.length; x++)
            {
                for (int y = 0; y < a[0].length; y++)
                {
                    if (a[x][y] == 1)
                    {
                        boolean wasAdded = false;
                        if (x > 0)
                            wasAdded = checkForNeighbourhood(list, x - 1, y, x, y);
                        if (!wasAdded && x < a.length - 1)
                            wasAdded = checkForNeighbourhood(list, x + 1, y, x, y);
                        if (!wasAdded && y > 0)
                            wasAdded = checkForNeighbourhood(list, x, y - 1, x, y);
                        if (!wasAdded && y < a[0].length - 1)
                            wasAdded = checkForNeighbourhood(list, x, y + 1, x, y);
                        if (!wasAdded)
                        {
                            Byte[][] b = new Byte[a.length][a[0].length];
                            b[x][y] = 1;
                            list.add(b);
                        }
                    }
                }
            }
        }

        return list.size();
    }

    private static boolean checkForNeighbourhood(ArrayList<Byte[][]> list, int x, int y, int origX, int origY)
    {
        boolean result = false;

        Iterator<Byte[][]> it = list.iterator();
        while (it.hasNext())
        {
            Byte[][] b = it.next();
            if (b[x][y] != null && b[x][y] == 1)
            {
                b[origX][origY] = 1;
                result = true;
                break;
            }
        }

        return result;
    }
}
