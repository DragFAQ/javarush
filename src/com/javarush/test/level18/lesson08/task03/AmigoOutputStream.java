package com.javarush.test.level18.lesson08.task03;

import java.io.*;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream
{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream outFile;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws IOException
    {
        super(fileName);
        this.outFile = fileOutputStream;
    }

    public static void main(String[] args) throws IOException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void close() throws IOException
    {
        outFile.flush();
        outFile.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        outFile.close();
    }

    @Override
    public void write(int b) throws IOException
    {
        super.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        outFile.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        super.write(b, off, len);
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }
}
