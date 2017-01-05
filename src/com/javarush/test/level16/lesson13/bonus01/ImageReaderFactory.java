package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    static ImageReader getReader (ImageTypes imageType) throws IllegalArgumentException {
        ImageReader result = null;

        if (imageType == ImageTypes.JPG)
            result = new JpgReader();
        else if (imageType == ImageTypes.BMP)
            result = new BmpReader();
        else if (imageType == ImageTypes.PNG)
            result = new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");

        return result;
    }
}
