package Modules;

import java.awt.image.BufferedImage;

//Nivelul superior din care vom mosteni cele 2 clase WriteImage si DefineMethods
//Aceasta clasa este abstracta continand doar o metoda abstracta
abstract public class ReadImage {
    //Metoda abstracta care ulterior va fi implementata pentru citirea imaginii din PC
    abstract public BufferedImage readImage(String path);
}
