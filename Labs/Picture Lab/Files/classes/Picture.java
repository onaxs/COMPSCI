import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represe2nts a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture () {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName) {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width) {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture) {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image) {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString() {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue() {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the red and blue to 0 */
  public void greenOnly() {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  /** Method to set the red,green,blue to (255 - its original value)  */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(225 - pixelObj.getBlue());
        pixelObj.setRed(225 - pixelObj.getRed());
        pixelObj.setGreen(225 - pixelObj.getGreen());
      }
    }
  }
  
  /** Method to set all red,green,blue to the average of the three values  */
  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int avg = (pixelObj.getBlue()+pixelObj.getRed()+pixelObj.getGreen())/3;
        pixelObj.setBlue(avg);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
      }
    }
  }
  
  /** Method to make the shape of the fish stand out  */
  public void enhanceFish() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {

        pixelObj.setGreen((int)(pixelObj.getGreen()*.7));

        if (pixelObj.getBlue()>160) {
          pixelObj.setBlue(240);
        }
        else pixelObj.setBlue((int)(pixelObj.getBlue()*.8));
        if (pixelObj.getRed()< 30 && pixelObj.getRed() > 10) {
          pixelObj.setRed(0);
        }
        else pixelObj.setRed(pixelObj.getRed()*4);
      }
    }
  }
  
  /** Method to highlight the edges of object in a picture by checking large changes in color */
  public void edgeDetection() {
    Pixel [][] pic = this.getPixels2D();

    for (int i = 0; i < pic.length; i++) {
      for (int j = 0; j < pic[i].length; j ++) {
        if (j + 1 < pic[i].length) {
          if (Pixel.colorDistance(pic[i][j].getColor(), pic[i][j + 1].getColor()) > 8) {
            pic[i][j].setColor(Color.BLACK);
          }
          else pic[i][j].setColor(Color.WHITE);
        } 
        else pic[i][j].setColor(Color.WHITE);
      }
    }
  }
  
  
  /** Method to mirror the picture around a vertical line in the center of the picture from left to right */
  public void mirrorVertical() {
    Pixel[][] pic = this.getPixels2D();

    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = this.getWidth() / 2 + 1; j < this.getWidth(); j++) {
        int dist = (this.getWidth() / 2) * 2 - j;
        pic[i][j].setColor(pic[i][dist].getColor());
      }
    }
  }
  
  /** Method to mirror around a diagonal line from bottom left to top right */
  public void mirrorDiagonal() {
    Pixel[][] pic = this.getPixels2D();

    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = i; j < this.getHeight(); j++) {
        pic[i][j].setColor(pic[j][i].getColor());
      }
    }
  }
    
  /** Method to mirror just part of a picture of a temple to fix the broken part of the temple */
  public void mirrorTemple() {
    Pixel[][] pic = this.getPixels2D();

    for (int i = 0; i < 98; i++) {
      for (int j = this.getWidth()/2 +1; j < this.getWidth(); j++) {
        int d = this.getWidth()/2 - (j - this.getWidth()/2);
        pic[i][j].setColor(pic[i][d].getColor());
      }
    }
  }
  
  /** Method to mirror just part of a picture of a snowman, so that it will have four arms instead of two */
  public void mirrorArms() {
    int reflect = 195;
    Pixel[][] pic = this.getPixels2D();

    for (int i = 160; i < reflect; i++){
      for (int j = 100; j < 300; j++) {
        if (j < 170 || j > 238) {
          int d = reflect + (reflect - i);
          pic[d][j].setColor(pic[i][j].getColor());
        }
        else continue;
      }
    }
  }
  
  /** Method to copy the gull in the picture to another location of the picture */
  public void copyGull() {
    Pixel[][] pic = this.getPixels2D();
    int reflect = 345;

    for (int i = 230; i < 320; i++) {
      for (int j = reflect + 1; j < reflect + 110; j++) {
        int d = reflect - (j - reflect); 
        pic[i][j].setColor(pic[i][d].getColor());
      }
    }
  }
  
  public void copy(Picture fromPic, 
                 int row , int column)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int i = 0, x = row; i < fromPixels.length && x < toPixels.length; i++, x++) {
      for (int j = 0, y = column; j < fromPixels[0].length && y < toPixels[0].length; j++, y++) {
        fromPixel = fromPixels[i][j];
        toPixel = toPixels[x][y];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
   
  
  /** Method to replace the blue background with the pixels in the newBack picture
    * @param newBack the picture to copy from
    */
  public void chromakey(Picture newBack) {
    Pixel[][] subject = this.getPixels2D();
    Pixel[][] background = newBack.getPixels2D();

    for (int i = 0; i < subject.length; i++) {
      for (int j = 0; j < subject[i].length; j++) {
        if (subject[i][j].getBlue() + 10 > subject[i][j].getRed() + subject[i][j].getGreen()) {
          subject[i][j].setColor(background[i][j].getColor());
        }
        else continue;
      }
    }
  }
  
  /** Method to decode a message hidden in the red value of the current picture */
  public void decode() {
    Pixel[][] pic = this.getPixels2D();
      
    for (Pixel[] rowArray : pic) {
      for (Pixel pixelObj : rowArray) {
        if (pixelObj.getRed() % 2 == 0) {
          pixelObj.setColor(Color.BLACK);
        }  
        else {
          pixelObj.setColor(Color.WHITE);
        }  
      }
    }
  }
  
  /** Hide a black and white message in the current picture by changing the green to even and then setting it to odd if the message pixel is black 
    * @param messagePict the picture with a message
    */
  public void encodeGreen(Picture messagePict) {
    Pixel[][] message = messagePict.getPixels2D();
    Pixel[][] pic = this.getPixels2D();

    for (int i = 0; i < pic.length; i++) {
      for (int j = 0; j < pic[i].length; j++) {
        if (message[i][j].getColor().equals(Color.BLACK)) {
          if (pic[i][j].getColor().getGreen() % 2 == 0) {
            pic[i][j].setGreen(pic[i][j].getColor().getGreen() + 1);
          }
          else continue;
        }
        else {
          if (pic[i][j].getColor().getGreen() % 2 != 0){
            pic[i][j].setGreen(pic[i][j].getColor().getGreen() + 1);
          }
        }
      }
    }
  }

  public void decodeGreen() {
    Pixel[][] pic = this.getPixels2D();
      
    for (Pixel[] rowArray : pic) {
      for (Pixel pixelObj : rowArray) {
        if (pixelObj.getGreen() % 2 == 0) {
          pixelObj.setColor(Color.BLACK);
        }  
        else {
          pixelObj.setColor(Color.WHITE);
        }  
      }
    }
  }
} 

