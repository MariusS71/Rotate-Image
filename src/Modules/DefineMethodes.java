package Modules;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Al treilea nivel de mostenire
//Aici vom implementa metodele de citire si scriere a imaginii

public class DefineMethodes extends WriteImage{

    //Implementarea functiei de citire a imaginii
    @Override
    public BufferedImage readImage(String path) {
        BufferedImage image = null;
        File f = null;

        try {
            f = new File(path);//imagine file
            image = ImageIO.read(f);
            System.out.println("Citire reusita");
        }catch(IOException e) {
            System.out.println("Error readImage: "+e);
        }

        return image;
    }

    //Implementarea functiei de scriere a imaginii
    @Override
    public void writeImage(String path, BufferedImage image) {
        try {
            File output = new File(path);
            ImageIO.write(image, "png", output);
            System.out.println("Scriere reusita");
            }
        catch(IOException e) {
            System.out.println("Error writeImage: " +e);
        }
    }
}
