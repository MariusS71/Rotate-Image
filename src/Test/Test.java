package Test;

import Modules.DefineMethodes;
import Modules.RotateImage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Numele pozei: ");
        String name= in.nextLine();

        System.out.println("Calea fisierului de intrare: ");
        String entryPath= in.nextLine();

        System.out.println("Introduceti calea fisierului de iesire: ");
        String outPath= in.nextLine();

        //Verificare date corecte
        int grades=0;
        while(grades!= 90 && grades != 180 && grades!=270) {
            System.out.println("Rotire la 90, 180 sau 270?");
            grades = in.nextInt();
        }

        //Citirea imaginii si crearea obiectului de tip RotateImage care va contine imaginea
        //care trebuie rotita
        DefineMethodes t1 = new DefineMethodes(); //obiect creeat pentru apelarea functiilor readImage si writeImage
        //timp de citire
      	double start = System.currentTimeMillis();
        //BufferedImage old = t1.readImage("C:\\Users\\saioc\\Desktop\\picture.bmp");
        BufferedImage old = t1.readImage(entryPath+ "\\"+ name);
        RotateImage t= new RotateImage(old, grades);
        System.out.println("Citirea imaginii a durat: " + (System.currentTimeMillis()-start));

        //Apelarea functiei care va roti imaginea din obiectul t
        start = System.currentTimeMillis(); //start timp de rotatie
        t.rotateImage(grades);
        System.out.println("Rotatia imaginii a durat: " +(System.currentTimeMillis()-start));

        //Scrierea noii imagini
        start = System.currentTimeMillis(); //start scriere imagine
        //t1.writeImage("C:\\Users\\saioc\\Desktop\\poza.bmp ", t.getRotatedImage());
        t1.writeImage(outPath+ "\\"+ "rotated_"+name, t.getRotatedImage());
        System.out.println("Scrierea imaginii a durat: " +(System.currentTimeMillis()-start));
    }
}
