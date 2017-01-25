package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        for (Word w : words)
            System.out.println(w);
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();

        if (crossword.length > 0 && crossword[0].length > 0)
        {
            boolean wasAdded;

            for (String word : words)
            {
                if (!word.isEmpty())
                {
                    wasAdded = false;
                    char firstLetter = word.charAt(0);
                    for (int x = 0; x < crossword.length; x++)
                    {
                        if (wasAdded)
                            break;
                        for (int y = 0; y < crossword[0].length; y++)
                        {
                            if (wasAdded)
                                break;

                            if (crossword[x][y] == firstLetter)
                            {
                                Word w = searchFullWord(crossword, x, y, word);
                                if (w != null)
                                {
                                    result.add(w);
                                    wasAdded = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private static Word searchFullWord(int[][] crossword, int x, int y, String word)
    {
        Word result = null;

        Pos pos = null;
        char[] chars = word.toCharArray();

        if (word.length() == 1)
            pos = new Pos(x, y);

        ArrayList<Directions> dirs = new ArrayList<Directions>() {{
            add(Directions.UP);
            add(Directions.DOWN);
            add(Directions.DOWN_LEFT);
            add(Directions.DOWN_RIGHT);
            add(Directions.LEFT);
            add(Directions.RIGHT);
            add(Directions.UP_LEFT);
            add(Directions.UP_RIGHT);
        }};

        for (Directions dir : dirs)
        {
            if (pos != null)
                break;
            pos = findByDirection(crossword, chars, 0, x, y, dir);
        }

        if (pos != null)
        {
            Word w = new Word(word);
            w.setStartPoint(y, x);
            w.setEndPoint(pos.y, pos.x);
            result = w;
        }

        return result;
    }

    private static Pos findByDirection(int[][] crossword, char[] chars, int i, int x, int y, Directions dir)
    {
        Pos result = null;

        switch (dir)
        {
            case UP:
                if (y < crossword[0].length - 1)
                    result = compareNextChar(crossword, chars, x, y + 1, i + 1, dir);
                break;
            case DOWN:
                if (y > 0)
                    result = compareNextChar(crossword, chars, x, y - 1, i + 1, dir);
                break;
            case LEFT:
                if (x > 0)
                    result = compareNextChar(crossword, chars, x - 1, y, i + 1, dir);
                break;
            case RIGHT:
                if (x < crossword.length - 1)
                    result = compareNextChar(crossword, chars, x + 1, y, i + 1, dir);
                break;
            case UP_RIGHT:
                if (x < crossword.length - 1 && y < crossword[0].length - 1)
                    result = compareNextChar(crossword, chars, x + 1, y + 1, i + 1, dir);
                break;
            case UP_LEFT:
                if (x > 0 && y < crossword[0].length - 1)
                    result = compareNextChar(crossword, chars, x - 1, y + 1, i + 1, dir);
                break;
            case DOWN_LEFT:
                if (x > 0 && y > 0)
                    result = compareNextChar(crossword, chars, x - 1, y - 1, i + 1, dir);
                break;
            case DOWN_RIGHT:
                if (x < crossword.length - 1 && y > 0)
                    result = compareNextChar(crossword, chars, x + 1, y - 1, i + 1, dir);
                break;
        }

        return result;
    }

    private static Pos compareNextChar(int[][] crossword, char[] chars, int x, int y, int i, Directions dir)
    {
        Pos result = null;

        if (crossword[x][y] == chars[i])
        {
            if (i == chars.length - 1)
                result = new Pos(x, y);
            else
                result = findByDirection(crossword, chars, i, x, y, dir);
        }

        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public static class Pos
    {
        public int x;
        public int y;

        public Pos(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT,
        UP_RIGHT,
        UP_LEFT,
        DOWN_RIGHT,
        DOWN_LEFT;
    }
}
