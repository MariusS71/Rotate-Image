package Modules;

import java.awt.image.BufferedImage;

//Clasa care va pastra imaginea originala si cea dupa rotire, cat si datele acestora,
//avand in ea o metoda care creeaza imaginea rotita
public class RotateImage implements Interface{
     private BufferedImage originalImage; //imaginea originala
     private BufferedImage rotatedImage;  //imaginea rotita
     private int width; //latimea imaginii originale
     private int height; //inaltimea imaginii originale

    public RotateImage(BufferedImage originalImage, int k) { //Constructorul cu parameterii
        this.originalImage = originalImage;
        if(k == 90 || k == 270) { //Alegerea dimensiunii noii imagini in functie de unghiul de rotatie
            this.rotatedImage = new BufferedImage(originalImage.getHeight(), originalImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        }
        else {
            this.rotatedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        }
        this.width = originalImage.getWidth();
        this.height =  originalImage.getHeight();
    }

    public RotateImage() {

    }

    //Metodele de get si set ale clasei
    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getRotatedImage() {
        return rotatedImage;
    }

    public void setRotatedImage(BufferedImage rotatedImage) {
        this.rotatedImage = rotatedImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //Metoda care creeaza imaginea rotita
    public void rotateImage(int check) {

        if(check == 90){ //Algoritmul pentru rotirea la 90 de grade
            for(int i=0; i<width; i++)
                for(int j=0; j < height; j++)
                    rotatedImage.setRGB(j, sum(width,-i,-1), originalImage.getRGB(i,j));
        }
        else if(check == 180){ //Algoritmul pentru rotirea la 180 de grade
            for( int i=0; i<width; i++)
                for( int j=0; j<height; j++)
                    rotatedImage.setRGB(sum(width,-i,-1), sum(height, -j, -1), originalImage.getRGB(i,j));
        }
        else if(check == 270){ //Algoritmul pentru rotirea la 270 de grade
            for( int i=0; i<width; i=sum(i,1))
                for( int j=0 ; j < height ; j=sum(j,1)){
                    rotatedImage.setRGB(sum(height,-1, -j), i, originalImage.getRGB(i,j));}
        }
        System.out.println("Rotire reusita");
    }

    //Metoda sum este o metoda didactica care intoarce rezultatul sumei valorilor primite
    // ca parametrii (pentru a folosi varargs)
    public int sum(int... n)
    {
        int sum=0;
        for(int i:n) {
            sum+=i;
        }
        return sum;
    }


}
