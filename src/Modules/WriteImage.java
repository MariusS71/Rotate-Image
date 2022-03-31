package Modules;

import java.awt.image.BufferedImage;

//Al doilea nivel de mostenire
//Clasa abstracta continand doar o metoda abstracta
abstract public class WriteImage extends ReadImage {
    //metoda abstracta
    abstract public void writeImage(String path, BufferedImage image);
}
